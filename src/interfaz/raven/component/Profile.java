package interfaz.raven.component;

import java.awt.Image;
import javax.swing.ImageIcon;

/*
    DESCRIPCIÓN

       Este panel se ubica en el tope del panel de menús. Tiene el logo de 
       Malaika Store y el nombre del sistema. 
*/
public class Profile extends javax.swing.JPanel {

    public Profile() {
        initComponents();
        setOpaque(false);   
    }
    
    public void escalarImagen(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/malaikaIcono2.jpg"));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        label.setIcon(scaledIcon);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();

        label.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        label.setForeground(new java.awt.Color(224, 224, 224));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
