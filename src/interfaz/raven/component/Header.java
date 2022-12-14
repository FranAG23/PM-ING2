package interfaz.raven.component;

import clasesControl.ControladorAdvertirFinReserva;
import clasesControl.ControladorGenerarNotificacionesFinReserva;
import clasesControl.ControladorNotificarFinReserva;
import interfaz.main.Main;
import interfaz.raven.swing.ButtonBadges;
import java.awt.event.ActionListener;

/*
    DESCRIPCIÓN

       Este panel es el encabezado que contiene la foto y nombre del usuario
       que está usando el sistema, así como botones para cerrar/abrir el panel
       de menús o ver notificaciones pendientes. Si se quiere cambiar alguna
       imágen ir a 'Design'.  
*/

public class Header extends javax.swing.JPanel {

    private Main main;
        
    public Header(Main main) {
        initComponents();
        this.main = main;
    }

    public void addMenuEvent(ActionListener event) {
        cmdMenu.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new interfaz.raven.swing.Button();
        pic = new interfaz.raven.swing.ImageAvatar();
        lbUserName = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botonReservasVencidas = new interfaz.raven.swing.ButtonBadges();
        botonReservasPorVencerse = new interfaz.raven.swing.ButtonBadges();

        setBackground(new java.awt.Color(255, 255, 255));

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png"))); // NOI18N

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarioMarcela3.jpg"))); // NOI18N

        lbUserName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbUserName.setForeground(new java.awt.Color(127, 127, 127));
        lbUserName.setText("Marcela03");

        lbRole.setForeground(new java.awt.Color(127, 127, 127));
        lbRole.setText("Usuario");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        botonReservasVencidas.setForeground(new java.awt.Color(250, 49, 49));
        botonReservasVencidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/notification.png"))); // NOI18N
        botonReservasVencidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReservasVencidasActionPerformed(evt);
            }
        });

        botonReservasPorVencerse.setForeground(new java.awt.Color(63, 178, 232));
        botonReservasPorVencerse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/message.png"))); // NOI18N
        botonReservasPorVencerse.setBadges(16);
        botonReservasPorVencerse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReservasPorVencerseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 367, Short.MAX_VALUE)
                .addComponent(botonReservasPorVencerse, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(botonReservasVencidas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUserName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbRole, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbUserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbRole))
                    .addComponent(cmdMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(botonReservasVencidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonReservasPorVencerse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonReservasPorVencerseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReservasPorVencerseActionPerformed
        
        new ControladorGenerarNotificacionesFinReserva(main);
        new ControladorAdvertirFinReserva(main);
    }//GEN-LAST:event_botonReservasPorVencerseActionPerformed

    private void botonReservasVencidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReservasVencidasActionPerformed

        new ControladorGenerarNotificacionesFinReserva(main);
        new ControladorNotificarFinReserva(main);
    }//GEN-LAST:event_botonReservasVencidasActionPerformed

    public ButtonBadges getBotonReservasPorVencerse(){return botonReservasPorVencerse;}
    public ButtonBadges getBotonReservasVencidas(){return botonReservasVencidas;}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private interfaz.raven.swing.ButtonBadges botonReservasPorVencerse;
    private interfaz.raven.swing.ButtonBadges botonReservasVencidas;
    private interfaz.raven.swing.Button cmdMenu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUserName;
    private interfaz.raven.swing.ImageAvatar pic;
    // End of variables declaration//GEN-END:variables
}
