package interfaz.main;

import baseDatos.BaseDatos;
import clasesEntidad.TimerNotificaciones;
import dataTransferObject.VentaNotificacionDTO;
import interfaz.raven.component.Header;
import interfaz.raven.component.Menu;
import interfaz.raven.event.EventMenuSelected;
import interfaz.raven.event.EventShowPopupMenu;
import interfaz.nuestrosFormularios.*;
import interfaz.raven.swing.ButtonBadges;
import interfaz.raven.swing.MenuItem;
import interfaz.raven.swing.PopupMenu;
import interfaz.raven.swing.icon.GoogleMaterialDesignIcons;
import interfaz.raven.swing.icon.IconFontSwing;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/*
    DESCRIPCIÓN:

        La ventana JFrame contiene un objeto JLayeredPane llamado 'bg', sobre el
        el que se colocan los elementos principales de la interfaz, como el pa- 
        nel de menús, el encabezado y el formulario. Los objetos JLayeredPane
        funcionan como objetos JPanel, pero permiten especificar una 
        'profundidad' a sus elementos.       
*/
public class Main extends javax.swing.JFrame {

    // Un objeto MigLayout permite diseñar un Jpanel con código. Permite 
    // configuraciones imposibles de realizar con el editor de Netbeans. 
    // Una guia para entender esta componente se encuentra en:
    // http://www.migcalendar.com/miglayout/mavensite/docs/cheatsheet.html. 
    private MigLayout layout;
    
    // Menú de opciones. 
    private Menu menu;
    
    // Encabezado
    private Header header;
    
    // Formulario principal
    private MainForm main;
    
    // Objeto usado para las animaciones. 
    private Animator animator;
    
    // Timer para las notificaciones
    private TimerNotificaciones timer;

    public Main() throws SQLException {
        
        initComponents();
        init();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Iniciar timer
        timer = new TimerNotificaciones(this);
        
    }

    
    
    // Función que inicializa componentes creadas por Raven. 
    private void init() throws SQLException, SQLException {
        
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header(this);
        main = new MainForm();

        // Agregamos el evento menuSelected al objeto menú. Este a su vez 
        // se lo pasa a los objetos MenuItem para que puedan llamarlo cuando 
        // el usuario clickea un menú o submenú. 
        menu.addEvent(new EventMenuSelected(){
            @Override    
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                
                // En esta sección elegimos el formulario a mostrar por pantalla
                // en base al menú seleccionado. 
                switch(menuIndex){
                    case 0:
                    {
                        try {
                            main.showForm(new Form_Home());
                        } catch (SQLException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;

                    case 1:
                        switch(subMenuIndex){
                            case 0:
                                main.showForm(new FormularioAltaProductoConScroll());
                                break;
                        }
                        break;
                    case 2:
                        switch(subMenuIndex){
                            case 0:
                                main.showForm(new FormularioAltaVentaConScroll());
                                break;
                            case 1:
                                main.showForm(new FormularioConsultarVentaConScroll()); 
                                break;
                            
                        }
                        break;
                }
            }
        });
        
        // Agregamos el evento showPopup al objeto menú para que este pueda 
        // invocarlo. El código de showPopup muestra en pantalla los submenús 
        // de algún menú clickeado por el usuario. Solo se invoca cuando el 
        // panel de menús no está desplegado totalmente en pantalla.
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main.this.getX() + 52;
                int y = Main.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        
        // Iniciar los menús del panel de menús. 
        menu.initMenuItem();
        
        // Los significados de estas configuraciones son:
        // w: ancho del componente.
        // h: alto del componente.
        // !: NI IDEA
        // spany: NI IDEA. 
        // wrap: envuelve a todo el jpanel. 
        bg.add(menu, "w 230!, spany 2");    
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        
        // Estos métodos son ejecutados automáticamente por la clase Animator.
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            // Método ejecutado cuando termina la animación que abre/cierra el
            // panel de menús. 
            public void end() {
                // Indicar que el panel de menús está abierto/cerrado. 
                menu.setShowMenu(!menu.isShowMenu());
                // Habilitar animaciones de menú.
                menu.setEnableMenu(true);
            }
        };
        
        // Configuraciones de la animación que muestra/esconde el panel de 
        // opciones. Si queremos cambiar la velocidad de la animación, hay que 
        // modificar el primer campo del constructor. 
        animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        
        // Agregamos un 'listener' que detecta las acciones que el usuario hace
        // sobre el encabezado de la aplicación. Cuando se detecta una acción, 
        // se ejecuta el código de actionPerformed(). 
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Si la animación de abrir/cerrar no está corriendo,
                if (!animator.isRunning()) {
                    // entonces comenzar animación.
                    animator.start();
                }  
                
                // Deshabilitar animaciones de menú momentaneamente.
                menu.setEnableMenu(false);
                
                // Si el panel de menús está en pantalla,
                if (menu.isShowMenu()) {
                    // entonces cerrar cada menú abierto. 
                    menu.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        main.showForm(new Form_Home());
    }

    public void generarNotificacionesFinReserva(ArrayList<VentaNotificacionDTO> v) {
        
        DefaultTableModel mod = (DefaultTableModel)tablaNotif.getModel();
        
        for (VentaNotificacionDTO i : v) {
            
            Object row[] = new Object[4];
            row[0] = i.getNombreCliente();
            row[1] = i.getTelefonoCliente();
            row[2] = i.getImporteActual();
            row[3] = new java.sql.Date(i.getFechaReserva().getTime());
            
            mod.addRow(row);
        }
        
        // Cambiar número en ícono
        ButtonBadges boton = header.getBotonReservasVencidas();
        boton.setBadges(boton.getBadges() + v.size());
        boton.repaint();
    }
    
    public void generarAdvertenciasFinReserva(ArrayList<VentaNotificacionDTO> v) {
    
        resetTablaAdv();
        
        DefaultTableModel mod = (DefaultTableModel)tablaAdv.getModel();
        
        for (VentaNotificacionDTO i : v) {
            
            Object row[] = new Object[4];
            row[0] = i.getNombreCliente();
            row[1] = i.getTelefonoCliente();
            row[2] = i.getImporteActual();
            row[3] = new java.sql.Date(i.getFechaReserva().getTime());
            
            mod.addRow(row);
        }
        
        // Cambiar número en ícono
        header.getBotonReservasPorVencerse().setBadges(v.size());
        header.getBotonReservasPorVencerse().repaint();
    }
    
    public void mostrarReservasVencidas() {
        
        dialogNotif.setLocationRelativeTo(null);
        dialogNotif.setVisible(true);
    }
    
    public void mostrarReservasPorVencerse() {
        
        dialogAdv.setLocationRelativeTo(null);
        dialogAdv.setVisible(true);
    }
    
    public void resetTablaNotif() {
        
        tablaNotif.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Cliente", "Teléfono", "Importe actual", "Inicio de reserva"
            }));
    }
    
    public void resetTablaAdv() {
        
        tablaAdv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Cliente", "Teléfono", "Importe actual", "Inicio de reserva"
            }));
    }
    
    public Header getHeader() {return header;}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogNotif = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaNotif = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        dialogAdv = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaAdv = new javax.swing.JTable();
        bg = new javax.swing.JLayeredPane();

        dialogNotif.setMinimumSize(new java.awt.Dimension(558, 402));
        dialogNotif.setUndecorated(true);
        dialogNotif.setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);

        jPanel4.setBackground(new java.awt.Color(238, 156, 167));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reservas vencidas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tablaNotif.setBackground(new java.awt.Color(255, 255, 255));
        tablaNotif.setForeground(new java.awt.Color(51, 51, 51));
        tablaNotif.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Teléfono", "Importe actual", "Inicio de reserva"
            }
        ));
        tablaNotif.setShowGrid(false);
        jScrollPane2.setViewportView(tablaNotif);
        if (tablaNotif.getColumnModel().getColumnCount() > 0) {
            tablaNotif.getColumnModel().getColumn(0).setHeaderValue("Cliente");
            tablaNotif.getColumnModel().getColumn(1).setHeaderValue("Teléfono");
            tablaNotif.getColumnModel().getColumn(2).setHeaderValue("Importe actual");
            tablaNotif.getColumnModel().getColumn(3).setHeaderValue("Inicio de reserva");
        }

        jButton1.setText("Marcar como leído");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogNotifLayout = new javax.swing.GroupLayout(dialogNotif.getContentPane());
        dialogNotif.getContentPane().setLayout(dialogNotifLayout);
        dialogNotifLayout.setHorizontalGroup(
            dialogNotifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogNotifLayout.setVerticalGroup(
            dialogNotifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialogAdv.setMinimumSize(new java.awt.Dimension(558, 382));
        dialogAdv.setUndecorated(true);
        dialogAdv.setResizable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setOpaque(false);

        jPanel6.setBackground(new java.awt.Color(238, 156, 167));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Reservas que vencen hoy");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tablaAdv.setBackground(new java.awt.Color(255, 255, 255));
        tablaAdv.setForeground(new java.awt.Color(51, 51, 51));
        tablaAdv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Teléfono", "Importe actual", "Inicio de reserva"
            }
        ));
        tablaAdv.setShowGrid(false);
        jScrollPane3.setViewportView(tablaAdv);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dialogAdvLayout = new javax.swing.GroupLayout(dialogAdv.getContentPane());
        dialogAdv.getContentPane().setLayout(dialogAdvLayout);
        dialogAdvLayout.setHorizontalGroup(
            dialogAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogAdvLayout.setVerticalGroup(
            dialogAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Malaika Store");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        // (Intentar) cerrar la conexión con la Base de Datos y cerrar la aplicación
        
        BaseDatos.getInstance().cerrarConexion();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resetTablaNotif();
        header.getBotonReservasVencidas().setBadges(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private javax.swing.JDialog dialogAdv;
    private javax.swing.JDialog dialogNotif;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaAdv;
    private javax.swing.JTable tablaNotif;
    // End of variables declaration//GEN-END:variables
}
