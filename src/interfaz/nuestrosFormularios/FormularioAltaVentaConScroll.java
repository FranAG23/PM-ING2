package interfaz.nuestrosFormularios;

import interfaz.raven.scrollbar.ScrollBarCustom;
import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JScrollBar;

public class FormularioAltaVentaConScroll extends javax.swing.JPanel {
    
    public FormularioAltaVentaConScroll() {
        initComponents();
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        formularioAltaVenta.setPanelQueMeContiene(this);
    }
   
    public void bajaScroll(){
        JScrollBar verticalBar = sp.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        formularioAltaVenta = new interfaz.nuestrosFormularios.FormularioAltaVenta();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setBorder(null);
        sp.setForeground(new java.awt.Color(255, 255, 255));
        sp.setOpaque(false);
        sp.setViewportView(formularioAltaVenta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1739, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSucursalActionPerformed
    }//GEN-LAST:event_campoSucursalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private interfaz.nuestrosFormularios.FormularioAltaVenta formularioAltaVenta;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
