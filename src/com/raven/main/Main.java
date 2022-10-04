package com.raven.main;

import com.raven.component.Header;
import com.raven.component.Menu;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.form.FormularioConsultarVenta;
import com.raven.form.Form_Home;
import com.raven.form.FormularioAltaProducto;
import com.raven.form.FormularioAltaVenta;
import com.raven.form.MainForm;
import com.raven.swing.MenuItem;
import com.raven.swing.PopupMenu;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public Main() {
        initComponents();
        init();
    }

    // Función que inicializa componentes creadas por Raven. 
    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new MainForm();

        // Agregamos el evento menuSelected al objeto menú. Este a su vez 
        // se lo pasa a los objetos MenuItem para que puedan llamarlo cuando 
        // el usuario clickea un menú o submenú. 
        menu.addEvent(new EventMenuSelected() {
            @Override    
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                
                // En esta sección elegimos el formulario a mostrar por pantalla
                // en base al menú seleccionado. 
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
;                        main.showForm(new FormularioAltaProducto());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new FormularioConsultarVenta());
                    }
                }
                else if(menuIndex == 1){
                if (subMenuIndex == 0) {
                        main.showForm(new FormularioAltaVenta());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new FormularioConsultarVenta());
                    }
                }
                else if (menuIndex == 2)
                    main.showForm(new Form_Home()); 
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Malaika Store");

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
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
