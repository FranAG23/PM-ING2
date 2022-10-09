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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        campoApellido1 = new javax.swing.JTextField();
        button1 = new com.raven.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        jLabel11 = new javax.swing.JLabel();
        botonAgregarItem = new com.raven.swing.Button();
        campoApellido2 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaItems = new javax.swing.JTable();
        cartelErrorTablaVacia = new javax.swing.JLabel();
        botonEliminarItem = new com.raven.swing.Button();
        jSeparator3 = new javax.swing.JSeparator();
        botonCompletarVenta = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        jPanel3.setBackground(new java.awt.Color(238, 156, 167));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Alta Venta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
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

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel3.setText("Nombre del cliente");

        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel6.setText("Apellido del cliente");

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel7.setText("¿La venta es con envío gratis?");

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel8.setText("Método de pago");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setText("Sucursal");

        cartelErrorApellido.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelErrorApellido.setForeground(new java.awt.Color(255, 51, 51));
        cartelErrorApellido.setText("El apellido debe tener entre 0 y 30 caracteres");

        cartelErrorNombre.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelErrorNombre.setForeground(new java.awt.Color(255, 51, 51));
        cartelErrorNombre.setText("El nombre debe tener entre 0 y 30 caracteres");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel4.setText("Datos básicos");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel5.setText("Buscador productos");

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel10.setText("Nombre del producto");

        button1.setBackground(new java.awt.Color(238, 156, 167));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Buscar");
        button1.setToolTipText("");
        button1.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoria", "Stock actual", "Precio venta (unidad)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel11.setText("Cantidad a vender");

        botonAgregarItem.setBackground(new java.awt.Color(238, 156, 167));
        botonAgregarItem.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarItem.setText("Agregar item de venta");
        botonAgregarItem.setToolTipText("");
        botonAgregarItem.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        botonAgregarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarItemActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel9.setText("Items de venta agregados");

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

        botonEliminarItem.setBackground(new java.awt.Color(238, 156, 167));
        botonEliminarItem.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminarItem.setText("Eliminar item seleccionado");
        botonEliminarItem.setToolTipText("");
        botonEliminarItem.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        botonEliminarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarItemActionPerformed(evt);
            }
        });

        botonCompletarVenta.setText("Completar Venta");
        botonCompletarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompletarVentaActionPerformed(evt);
            }
        });

        jButton4.setText("Registrar Reserva");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(campoApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(592, 592, 592))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cartelErrorApellido)
                                    .addComponent(campoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                    .addComponent(campoApellido)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(campoSucursal, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cartelErrorNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(74, 74, 74)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(209, 209, 209)
                                        .addComponent(campoEnvioGratis))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(80, 80, 80)
                                        .addComponent(campoMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(32, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(cartelErrorTablaVacia)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonCompletarVenta))
                            .addComponent(jSeparator3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botonEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2)
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(100, 100, 100)
                                .addComponent(campoApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonAgregarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(32, 32, 32))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cartelErrorNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(campoMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cartelErrorApellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addComponent(campoEnvioGratis))
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(campoApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(32, 32, 32)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cartelErrorTablaVacia))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(botonEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCompletarVenta)
                    .addComponent(jButton4))
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

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

    }//GEN-LAST:event_button1ActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked

    }//GEN-LAST:event_table1MouseClicked

    private void botonAgregarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarItemActionPerformed
        DefaultTableModel model = (DefaultTableModel)tablaItems.getModel();
        model.addRow(new Object[]{0,"",0,0,0});
    }//GEN-LAST:event_botonAgregarItemActionPerformed

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
    private com.raven.swing.Button botonAgregarItem;
    private javax.swing.JButton botonCompletarVenta;
    private com.raven.swing.Button botonEliminarItem;
    private com.raven.swing.Button button1;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoApellido1;
    private javax.swing.JTextField campoApellido2;
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tablaItems;
    private com.raven.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
