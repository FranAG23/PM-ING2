package interfaz.nuestrosFormularios;

import interfaz.raven.scrollbar.ScrollBarCustom;

public class FormularioConsultarVentaConScroll extends javax.swing.JPanel {
    public FormularioConsultarVentaConScroll() {
        initComponents();
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        formularioConsultarVenta1 = new interfaz.nuestrosFormularios.FormularioConsultarVenta();

        sp.setBorder(null);
        sp.setOpaque(false);
        sp.setViewportView(formularioConsultarVenta1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private interfaz.nuestrosFormularios.FormularioConsultarVenta formularioConsultarVenta1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
