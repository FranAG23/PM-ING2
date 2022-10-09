package com.raven.form;
import clases_entidad.Venta; 
import clases_entidad.auxiliares.RenglonTablaAltaVenta;
import clases_control.ManagerVenta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormularioAltaVenta extends javax.swing.JPanel {
    ManagerVenta managerVenta = null; 
    
    public FormularioAltaVenta() {
        initComponents();
        setOpaque(false);
        campoMetodoPago.addItem(Venta.MetodoPago.EFECTIVO.toString());
        campoMetodoPago.addItem(Venta.MetodoPago.MERCADOPAGO.toString());
        campoSucursal.addItem("San Luis");
        campoSucursal.setEnabled(false);     
        cartelErrorNombre.setText(" ");
        cartelErrorApellido.setText(" ");
        cartelErrorTablaVacia.setText(" ");
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        botonAgregarItem = new javax.swing.JButton();
        botonEliminarItem = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        botonCompletarVenta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaItems = new javax.swing.JTable();
        cartelErrorTablaVacia = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoApellido = new javax.swing.JTextField();
        campoEnvioGratis = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        campoMetodoPago = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        campoSucursal = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cartelErrorApellido = new javax.swing.JLabel();
        cartelErrorNombre = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel9.setText("Items de Venta");

        botonAgregarItem.setText("Agregar Item de Venta");
        botonAgregarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarItemActionPerformed(evt);
            }
        });

        botonEliminarItem.setText("Eliminar Item de Venta");
        botonEliminarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarItemActionPerformed(evt);
            }
        });

        jButton4.setText("Registrar Reserva");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        botonCompletarVenta.setText("Completar Venta");
        botonCompletarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompletarVentaActionPerformed(evt);
            }
        });

        tablaItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre del producto", "Cantidad", "Precio por unidad", "Precio total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaItems.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaItems);
        if (tablaItems.getColumnModel().getColumnCount() > 0) {
            tablaItems.getColumnModel().getColumn(0).setResizable(false);
            tablaItems.getColumnModel().getColumn(4).setResizable(false);
        }

        cartelErrorTablaVacia.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelErrorTablaVacia.setForeground(new java.awt.Color(255, 51, 51));
        cartelErrorTablaVacia.setText("Tiene que agregar al menos un item de venta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonCompletarVenta)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(botonAgregarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonEliminarItem)
                                .addGap(18, 18, 18)
                                .addComponent(cartelErrorTablaVacia)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregarItem)
                    .addComponent(botonEliminarItem)
                    .addComponent(cartelErrorTablaVacia))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(botonCompletarVenta))
                .addGap(18, 18, 18))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel1.setText("Alta Venta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(253, 229, 229));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setText("Nombre del cliente");

        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel6.setText("Apellido del cliente");

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setText("¿La venta es con envío gratis?");

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel8.setText("Método de pago");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("Sucursal");

        cartelErrorApellido.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelErrorApellido.setForeground(new java.awt.Color(255, 51, 51));
        cartelErrorApellido.setText("El apellido debe tener entre 0 y 20 caracteres");

        cartelErrorNombre.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelErrorNombre.setForeground(new java.awt.Color(255, 51, 51));
        cartelErrorNombre.setText("El nombre debe tener entre 0 y 20 caracteres");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2))
                .addGap(162, 162, 162)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(campoEnvioGratis)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoSucursal, javax.swing.GroupLayout.Alignment.LEADING, 0, 600, Short.MAX_VALUE)
                            .addComponent(campoMetodoPago, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoApellido))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cartelErrorNombre)
                            .addComponent(cartelErrorApellido))
                        .addGap(0, 0, 0))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cartelErrorNombre)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(cartelErrorApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(campoEnvioGratis))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarCartelExito(){
        JOptionPane.showMessageDialog(this, "La venta se registró con éxito");
    }
    
    public void mostrarErrorNombre(){
        cartelErrorNombre.setText("El nombre debe tener entre 0 y 20 caracteres");
    }
    
    public void mostrarErrorApellido(){
        cartelErrorApellido.setText("El apellido debe tener entre 0 y 20 caracteres");
    }
    
    public void mostrarErrorTablaVacia(){
        cartelErrorTablaVacia.setText("Debe ingresar al menos un item de venta");
    }
    
    public void reiniciarCampos(){
        DefaultTableModel model = (DefaultTableModel)tablaItems.getModel();
        campoNombre.setText("");
        campoApellido.setText("");
        campoEnvioGratis.setSelected(false);
        campoMetodoPago.setSelectedIndex(0);
        while(model.getRowCount() != 0)
            model.removeRow(0);
        
    }
    
    public
         void mostrarCartelFracaso(){
        JOptionPane.showMessageDialog(this, "ERROR FATAL: la venta no pudo registrarse. Contacte con equipo de soporte");
    }
    
    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed

    }//GEN-LAST:event_campoNombreActionPerformed

    private void botonAgregarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarItemActionPerformed
        DefaultTableModel model = (DefaultTableModel)tablaItems.getModel();
        model.addRow(new Object[]{0,"",0,0,0});
    }//GEN-LAST:event_botonAgregarItemActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void botonCompletarVentaActionPerformed(java.awt.event.ActionEvent evt){        
        managerVenta = new ManagerVenta(this);
        ArrayList<RenglonTablaAltaVenta> listRenglones = new ArrayList<>();
        RenglonTablaAltaVenta renglon;
        
        // Obtener nombre de cliente:
        String nomCliente = campoNombre.getText();
        // Obtener apellido del cliente:
        String apeCliente = campoApellido.getText(); 
        // Obtener si la venta es con envio gratis o no:
        boolean envioGratis = campoEnvioGratis.isSelected(); 
        // Obtener metodo de pago:
        String strMetodoPago = campoMetodoPago.getSelectedItem().toString(); 
        // Obtener ubicacion de sucursal:
        String strUbiSucursal = campoSucursal.getSelectedItem().toString(); 
        
        // En este bloque de código lleno mi lista de renglones
        // Obtener modelo de la tabla:
        DefaultTableModel model = (DefaultTableModel)tablaItems.getModel();
        // Recorrer todas las filas de la tabla:
        for(int i = 0; i < model.getRowCount(); i++){
            // Crear nuevo renglon: 
            renglon = new RenglonTablaAltaVenta(); 
            renglon.setIDProducto((int)model.getValueAt(i, 0));
            renglon.setNombreProducto(model.getValueAt(i, 1).toString());
            renglon.setCantidad((int) model.getValueAt(i, 2));
            
            renglon.setPrecioPorUnidad((float) (model.getValueAt(i, 3)));
            listRenglones.add(renglon);       
        }
        
        // Reiniciar carteles de error:
        cartelErrorNombre.setText(" ");
        cartelErrorApellido.setText(" ");
        cartelErrorTablaVacia.setText(" ");
        
        // Trasmitir datos a manager de ventas:
        managerVenta.altaVenta(nomCliente, apeCliente, envioGratis, 1000, 
                                strMetodoPago, strUbiSucursal, listRenglones);
    }

    private void campoSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSucursalActionPerformed
    }//GEN-LAST:event_campoSucursalActionPerformed

    /*
        Descripción: Elimina la fila seleccionada por el usuario cuando este 
        aprieta el botón "Eliminar item de venta". 
    */
    private void botonEliminarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarItemActionPerformed
       // Obtener modelo de tabla de items.
       DefaultTableModel model = (DefaultTableModel)tablaItems.getModel();
       // Obtener fila seleccionada de tabla.
       int filaSeleccionada = tablaItems.getSelectedRow();
       // Si hay una fila seleccionada,
       if(filaSeleccionada != -1)
           // entonces borrar esa fila. 
           model.removeRow(tablaItems.getSelectedRow());
    }//GEN-LAST:event_botonEliminarItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarItem;
    private javax.swing.JButton botonCompletarVenta;
    private javax.swing.JButton botonEliminarItem;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JCheckBox campoEnvioGratis;
    private javax.swing.JComboBox<String> campoMetodoPago;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JComboBox<String> campoSucursal;
    private javax.swing.JLabel cartelErrorApellido;
    private javax.swing.JLabel cartelErrorNombre;
    private javax.swing.JLabel cartelErrorTablaVacia;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaItems;
    // End of variables declaration//GEN-END:variables
}
