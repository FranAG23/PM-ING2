package com.raven.form;
import clases_control.ManagerProducto;
import clases_entidad.Venta; 
import clases_entidad.auxiliares.RenglonTablaAltaVenta;
import clases_control.ManagerVenta;
import clases_entidad.Disponibilidad;
import clases_entidad.ItemVenta;
import clases_entidad.Producto;
import clases_entidad.Sucursal;
import clases_control.LogicaAltaVenta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormularioAltaVenta extends javax.swing.JPanel {
    LogicaAltaVenta logica;
    
    public FormularioAltaVenta() {
        initComponents();
        setOpaque(false);
        campoMetodoPago.addItem(Venta.MetodoPago.EFECTIVO.toString());
        campoMetodoPago.addItem(Venta.MetodoPago.MERCADOPAGO.toString());
        campoSucursal.addItem("San Luis");
        campoSucursal.setEnabled(false);     
        esconderCartelesDeError();
        logica = new LogicaAltaVenta(this);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCabecera = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelDatos = new javax.swing.JPanel();
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
        errorApellido = new javax.swing.JLabel();
        errorNombre = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        campoBuscador = new javax.swing.JTextField();
        botonBuscar = new com.raven.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBuscador = new com.raven.swing.table.Table();
        jLabel11 = new javax.swing.JLabel();
        botonAgregarItem = new com.raven.swing.Button();
        campoCantidad = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        errorTablaItems = new javax.swing.JLabel();
        botonEliminarItem = new com.raven.swing.Button();
        jSeparator3 = new javax.swing.JSeparator();
        botonRegistrarReserva = new com.raven.swing.Button();
        botonRegistrarVenta = new com.raven.swing.Button();
        errorNombreProducto = new javax.swing.JLabel();
        JScrollPane666 = new javax.swing.JScrollPane();
        tablaItems = new com.raven.swing.table.Table();
        errorCantidad = new javax.swing.JLabel();
        avisoMirarArriba = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        panelCabecera.setBackground(new java.awt.Color(238, 156, 167));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Alta Venta");

        javax.swing.GroupLayout panelCabeceraLayout = new javax.swing.GroupLayout(panelCabecera);
        panelCabecera.setLayout(panelCabeceraLayout);
        panelCabeceraLayout.setHorizontalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCabeceraLayout.setVerticalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCabeceraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        panelDatos.setBackground(new java.awt.Color(255, 255, 255));
        panelDatos.setForeground(new java.awt.Color(253, 229, 229));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel3.setText("Nombre del cliente");

        campoNombre.setBackground(new java.awt.Color(204, 204, 255));
        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel6.setText("Apellido del cliente");

        campoApellido.setBackground(new java.awt.Color(204, 204, 255));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel7.setText("¿La venta es con envío gratis?");

        campoMetodoPago.setBackground(new java.awt.Color(204, 204, 255));

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel8.setText("Método de pago");

        campoSucursal.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setText("Sucursal");

        errorApellido.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        errorApellido.setForeground(new java.awt.Color(255, 51, 51));
        errorApellido.setText("El apellido debe tener entre 1 y 30 caracteres");

        errorNombre.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        errorNombre.setForeground(new java.awt.Color(255, 51, 51));
        errorNombre.setText("El nombre debe tener entre 1 y 30 caracteres");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel4.setText("Datos básicos");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel5.setText("Buscador productos");

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel10.setText("Nombre del producto");

        campoBuscador.setBackground(new java.awt.Color(204, 204, 255));
        campoBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscadorActionPerformed(evt);
            }
        });

        botonBuscar.setBackground(new java.awt.Color(238, 156, 167));
        botonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscar.setText("Buscar");
        botonBuscar.setToolTipText("");
        botonBuscar.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        tablaBuscador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Categoria", "Descripcion", "Stock actual", "Precio venta (unidad)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBuscador.getTableHeader().setReorderingAllowed(false);
        tablaBuscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBuscadorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBuscador);
        if (tablaBuscador.getColumnModel().getColumnCount() > 0) {
            tablaBuscador.getColumnModel().getColumn(0).setResizable(false);
            tablaBuscador.getColumnModel().getColumn(1).setResizable(false);
            tablaBuscador.getColumnModel().getColumn(2).setResizable(false);
            tablaBuscador.getColumnModel().getColumn(3).setResizable(false);
            tablaBuscador.getColumnModel().getColumn(4).setResizable(false);
        }

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

        campoCantidad.setBackground(new java.awt.Color(204, 204, 255));

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel9.setText("Items de venta agregados");

        errorTablaItems.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        errorTablaItems.setForeground(new java.awt.Color(255, 51, 51));
        errorTablaItems.setText("Tiene que agregar al menos un item de venta");

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

        botonRegistrarReserva.setBackground(new java.awt.Color(238, 156, 167));
        botonRegistrarReserva.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistrarReserva.setText("Registrar reserva\n");
        botonRegistrarReserva.setToolTipText("");
        botonRegistrarReserva.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        botonRegistrarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarReservaActionPerformed(evt);
            }
        });

        botonRegistrarVenta.setBackground(new java.awt.Color(51, 255, 102));
        botonRegistrarVenta.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistrarVenta.setText("Registrar venta");
        botonRegistrarVenta.setToolTipText("");
        botonRegistrarVenta.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        botonRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarVentaActionPerformed(evt);
            }
        });

        errorNombreProducto.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        errorNombreProducto.setForeground(new java.awt.Color(255, 51, 51));
        errorNombreProducto.setText("El nombre debe tener entre 1 y 80 caracteres");

        tablaItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre producto", "Cantidad ", "Precio por unidad", "Precio total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JScrollPane666.setViewportView(tablaItems);

        errorCantidad.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        errorCantidad.setForeground(new java.awt.Color(255, 51, 51));
        errorCantidad.setText("Error formato de cantidad");

        avisoMirarArriba.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        avisoMirarArriba.setForeground(new java.awt.Color(255, 51, 51));
        avisoMirarArriba.setText("Hay un error! Mire arriba");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(errorTablaItems)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JScrollPane666, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(80, 80, 80)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(592, 592, 592))
                                    .addGroup(panelDatosLayout.createSequentialGroup()
                                        .addComponent(campoBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelDatosLayout.createSequentialGroup()
                                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelDatosLayout.createSequentialGroup()
                                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(errorApellido)
                                                    .addComponent(campoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                                    .addComponent(campoApellido)
                                                    .addComponent(campoSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(errorNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(74, 74, 74)
                                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(panelDatosLayout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addGap(209, 209, 209)
                                                        .addComponent(campoEnvioGratis))
                                                    .addGroup(panelDatosLayout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addGap(80, 80, 80)
                                                        .addComponent(campoMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(errorNombreProducto))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(botonRegistrarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(avisoMirarArriba)
                                .addGap(18, 18, 18)
                                .addComponent(botonRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botonEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(100, 100, 100)
                                .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(errorCantidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonAgregarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(errorNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(campoMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(errorApellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addComponent(campoEnvioGratis))
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addGap(8, 8, 8)
                .addComponent(errorNombreProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(campoBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(errorCantidad))
                .addGap(28, 28, 28)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(errorTablaItems))
                .addGap(32, 32, 32)
                .addComponent(JScrollPane666, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(botonEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avisoMirarArriba))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarCartelExito(){
        JOptionPane.showMessageDialog(this, "La venta se registró con éxito");
    }
    
    public void mostrarErrorNombre(){
        avisoMirarArriba.setText("Hay un error! Mire arriba");
        errorNombre.setText("El nombre debe tener entre 1 y 30 caracteres");
    }
    
    public void mostrarErrorApellido(){
        avisoMirarArriba.setText("Hay un error! Mire arriba");
        errorApellido.setText("El apellido debe tener entre 1 y 30 caracteres");
    }
    
    public void mostrarErrorTablaVacia(){
        avisoMirarArriba.setText("Hay un error! Mire arriba");
        errorTablaItems.setText("Debe ingresar al menos un item de venta");
    }
    
     public void advertirNoHayResultados(){
        errorNombreProducto.setText("No se encontraron productos");
    }
    
    public void mostrarErrorBuscadorNombre(){
        errorNombreProducto.setText("El nombre debe tener entre 1 y 80 caracteres");
    }
    
    public void esconderErrorBuscadorNombre(){
        errorNombreProducto.setText(" ");
    }
    
    public void esconderErrorBuscadorVacio(){
        errorNombreProducto.setText(" ");
    }
    
    public void borrarFilasDeProductos(){
        DefaultTableModel model = (DefaultTableModel)tablaBuscador.getModel();
        while(model.getRowCount() != 0)
            model.removeRow(0);
    }
    
    public void agregarFilaDeProducto(String nom, String cat, String desc, int stockActual, float precioVenta){  
            tablaBuscador.addRow(new Object[]{nom, cat, desc, stockActual, precioVenta});
    }
    public void agregarItemVenta(String nombre, int cantidad, float precioUnidad, float importeTotal) {
            tablaItems.addRow(new Object[]{nombre, cantidad, precioUnidad, importeTotal});
    }
    public void reiniciarCampos(){
        DefaultTableModel modeloProductos = (DefaultTableModel)tablaBuscador.getModel();
        DefaultTableModel modeloItems = (DefaultTableModel)tablaItems.getModel();
        campoNombre.setText("");
        campoApellido.setText("");
        campoEnvioGratis.setSelected(false);
        campoMetodoPago.setSelectedIndex(0);
        while(modeloProductos.getRowCount() != 0)
            modeloProductos.removeRow(0);
        while(modeloItems.getRowCount() != 0)
            modeloItems.removeRow(0);
    }
    
    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed

    }//GEN-LAST:event_campoNombreActionPerformed

    public void esconderCartelesDeError(){
        // Esconder carteles de error:
        errorNombre.setText(" ");
        errorApellido.setText(" ");
        errorTablaItems.setText(" ");
        errorNombreProducto.setText(" ");
        errorCantidad.setText(" ");
        avisoMirarArriba.setText(" ");
    }
    
    private void campoSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSucursalActionPerformed
    }//GEN-LAST:event_campoSucursalActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // Construir objeto producto:
        String nombreProducto = campoBuscador.getText();
        // Invocar a lógica de la acción.
        logica.usuarioBuscaProducto(nombreProducto, 1, "San Luis");
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void tablaBuscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBuscadorMouseClicked

    }//GEN-LAST:event_tablaBuscadorMouseClicked

    private void botonAgregarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarItemActionPerformed
        boolean datosValidos = true; 
        int cantidadAVender = 0; 
        int filaSeleccionada = -1; 
        DefaultTableModel modelo;
        
        // Obtener modelo de tabla de items.
        modelo = (DefaultTableModel)tablaBuscador.getModel();
        // Obtener fila seleccionada. 
        filaSeleccionada = tablaBuscador.getSelectedRow();
         
        // Ocultar cartel de error
        errorCantidad.setText(" ");
        
        // Validar que campoCantidad pueda transformarse a int.
        try
        {
            cantidadAVender = Integer.parseInt(campoCantidad.getText());
        } 
        catch (NumberFormatException e) 
        {
            errorCantidad.setText("Error en formato de cantidad ");
            datosValidos = false; 
        }
        // Si no hubo errores y hay al menos una fila seleccionada. 
        if(datosValidos && filaSeleccionada >= 0)
            // entonces invocar a la lógica de la acción. 
            logica.usuarioQuiereAgregarItem(filaSeleccionada, cantidadAVender);
    }//GEN-LAST:event_botonAgregarItemActionPerformed

    private void botonEliminarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarItemActionPerformed
       DefaultTableModel model;
       int filaSeleccionada = -1; 
       String nombreProducto = "";
        // Obtener modelo de tabla de items.
        model = (DefaultTableModel)tablaItems.getModel();
       // Obtener fila seleccionada de tabla.
       filaSeleccionada = tablaItems.getSelectedRow();
       // Si hay una fila seleccionada,
       if(filaSeleccionada >= 0)
       {
           // entonces obtener nombre del producto.
           nombreProducto = tablaItems.getValueAt(filaSeleccionada, 0).toString(); 
           // e invocar a la lógica de esa acción.
           logica.usuarioQuiereEliminarItem(filaSeleccionada, nombreProducto);
       }
           
    }//GEN-LAST:event_botonEliminarItemActionPerformed

    private void botonRegistrarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRegistrarReservaActionPerformed

    private void botonRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarVentaActionPerformed
        String nomCliente = campoNombre.getText();
        String apeCliente = campoApellido.getText();
        String strMetodoPago = campoMetodoPago.getSelectedItem().toString(); 
        String ubiSucursal = campoSucursal.getSelectedItem().toString(); 
        logica.usuarioQuiereCompletarVenta(nomCliente, apeCliente, true, strMetodoPago, 1, ubiSucursal);
    }//GEN-LAST:event_botonRegistrarVentaActionPerformed

    private void campoBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscadorActionPerformed

    }//GEN-LAST:event_campoBuscadorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane666;
    private javax.swing.JLabel avisoMirarArriba;
    private com.raven.swing.Button botonAgregarItem;
    private com.raven.swing.Button botonBuscar;
    private com.raven.swing.Button botonEliminarItem;
    private com.raven.swing.Button botonRegistrarReserva;
    private com.raven.swing.Button botonRegistrarVenta;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoBuscador;
    private javax.swing.JTextField campoCantidad;
    private javax.swing.JCheckBox campoEnvioGratis;
    private javax.swing.JComboBox<String> campoMetodoPago;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JComboBox<String> campoSucursal;
    private javax.swing.JLabel errorApellido;
    private javax.swing.JLabel errorCantidad;
    private javax.swing.JLabel errorNombre;
    private javax.swing.JLabel errorNombreProducto;
    private javax.swing.JLabel errorTablaItems;
    private javax.swing.Box.Filler filler1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panelCabecera;
    private javax.swing.JPanel panelDatos;
    private com.raven.swing.table.Table tablaBuscador;
    private com.raven.swing.table.Table tablaItems;
    // End of variables declaration//GEN-END:variables

    public void advertirCantidadNoPositiva() {
        errorCantidad.setText("La cantidad debe ser positiva");
    }

    public void indicarQueCantidadSuperaStock() {
        errorCantidad.setText("La cantidad supera el stock");
    }

    public void advertirItemRepetido() {
        errorTablaItems.setText("Quiere agregar un producto repetido");
    }

    public void eliminarFilaItemVenta(int filaSeleccionada) {
        DefaultTableModel model = (DefaultTableModel)tablaItems.getModel();
        model.removeRow(filaSeleccionada);
    }

    public void esconderAdvertenciaCantidadNegativa() {
        errorCantidad.setText(" ");
    }

    public void esconderAdvertenciaCantidadSuperaStock() {
        errorCantidad.setText(" ");
    }

    public void esconderAdvertenciaItemRepetido() {
        errorTablaItems.setText(" ");
    }

    public void mostrarCartelFracaso() {
        JOptionPane.showMessageDialog(this, "ERROR FATAL: Contacte con el equipo de soporte");
    }
}
