package com.raven.form;

public class panelConScrollAltaVenta extends javax.swing.JPanel {
    
    public panelConScrollAltaVenta() {
        initComponents();
        setOpaque(false);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        formularioAltaVenta1 = new com.raven.form.FormularioAltaVenta();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);
        jScrollPane1.setViewportView(formularioAltaVenta1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSucursalActionPerformed
    }//GEN-LAST:event_campoSucursalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.form.FormularioAltaVenta formularioAltaVenta1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
