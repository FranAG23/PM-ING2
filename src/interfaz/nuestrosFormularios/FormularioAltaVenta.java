package interfaz.nuestrosFormularios;

import clasesControl.ControladorAltaVenta;
import clasesEntidad.Venta;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class FormularioAltaVenta extends javax.swing.JPanel {
    private FormularioAltaVentaConScroll panelQueMeContiene; 
    private ControladorAltaVenta logica;
    
    public FormularioAltaVenta(){
        initComponents();
        panelDatosReserva.setVisible(false);
        campoMetodoPago.addItem(Venta.MetodoPago.EFECTIVO.toString());
        campoMetodoPago.addItem(Venta.MetodoPago.MERCADOPAGO.toString());
        campoSucursal.addItem("San Luis");
        campoSucursal.setEnabled(false); 
        campoMontoTotal.setText("0");    
        this.escondaTodosLosCartelesDeError();
        logica = new ControladorAltaVenta(this);
        
    }
    
    public void setPanelQueMeContiene(FormularioAltaVentaConScroll panel){
        panelQueMeContiene = panel; 
    }

     public void muestreCartelDeExito(){
        JOptionPane.showMessageDialog(this, "La venta se registró con éxito");
    }
     
     public void muestreCartelDeFracaso() {
        JOptionPane.showMessageDialog(this, "ERROR FATAL: Contacte con el equipo de soporte");
    }
    
    public void muestreErrorNombreCliente(){
        avisoMirarArriba.setText("Hay un error! Mire arriba");
        errorNombre.setText("El nombre debe tener entre 1 y 30 caracteres");
    }
    
    public void muestreErrorApellidoCliente(){
        avisoMirarArriba.setText("Hay un error! Mire arriba");
        errorApellido.setText("El apellido debe tener entre 1 y 30 caracteres");
    }
    
    public void muestreErrorPorTablaVacia(){
        avisoMirarArriba.setText("Hay un error! Mire arriba");
        errorTablaItems.setText("Debe ingresar al menos un item de venta");
    }
    
     public void adviertaNoHayResultados(){
        errorNombreProducto.setText("No se encontraron productos");
    }
    
    public void muestreErrorNombreProducto(){
        errorNombreProducto.setText("El nombre debe tener entre 1 y 80 caracteres");
    }
    
    public void muestreErrorFormatoCantidad() {
        errorCantidad.setText("La cantidad debe ser positiva");
    }

    public void muestreErrorCantidadSuperaStock() {
        errorCantidad.setText("La cantidad supera el stock");
    }

    public void muestreErrorItemRepetido() {
        errorTablaItems.setText("Quiere agregar un producto repetido");
    }
    
    public void muestreErrorFormatoCodArea() {
        errorTelefonoCliente.setText("El código de área debe ser un número");
    }
    
    public void muestreErrorTamañoCodArea() {
        errorTelefonoCliente.setText("El código de área debe tener entre 2 y 4 dígitos");
    }
    
    public void muestreErrorFormatoNumeroTelefono() {
        errorTelefonoCliente.setText("El número de teléfono debe ser un número");
    }
    
    public void muestreErrorTamañoNumeroTelefono() {
        errorTelefonoCliente.setText("El número de teléfono debe tener entre 6 y 8 dígitos");
    }
    
    public void muestreErrorSeñaNoPositiva(){
        errorSeña.setText("La seña debe ser positiva");
    }
    
    public void muestreErrorSeñaSuperaTotal(){
        errorSeña.setText("La seña no puede superar el importe total");
    }
    
    public void escondaErrorCantidadNegativa() {
        errorCantidad.setText(" ");
    }

    public void escondaErrorCantidadSuperaStock() {
        errorCantidad.setText(" ");
    }

    public void escondaErrorItemRepetido() {
        errorTablaItems.setText(" ");
    }
    
    public void escondaErrorNombreProducto(){
        errorNombreProducto.setText(" ");
    }
    
    public void escondaTodosLosCartelesDeError(){
        errorNombre.setText(" ");
        errorApellido.setText(" ");
        errorTablaItems.setText(" ");
        errorNombreProducto.setText(" ");
        errorCantidad.setText(" ");
        errorTelefonoCliente.setText(" ");
        errorSeña.setText(" ");
        avisoMirarArriba.setText(" ");
    }
     
    public void reinicieTodosLosCampos(){
        DefaultTableModel modeloProductos = (DefaultTableModel)tablaProductosEncontrados.getModel();
        DefaultTableModel modeloItems = (DefaultTableModel)tablaItems.getModel();
        campoNombre.setText("");
        campoApellido.setText("");
        campoEnvioGratis.setSelected(false);
        campoNombreProd.setText("");
        campoCantidad.setText("");
        campoMetodoPago.setSelectedIndex(0);
        campoCodArea.setText("");
        campoNumeroTelefono.setText("");
        campoSeña.setText("");
        campoVentaConReserva.setSelected(false);
        campoMontoTotal.setText("0");
        while(modeloProductos.getRowCount() != 0)
            modeloProductos.removeRow(0);
        while(modeloItems.getRowCount() != 0)
            modeloItems.removeRow(0);
        panelDatosReserva.setVisible(false);
    }
    
     public void establezcaMontoTotal(float montoTotal){
        campoMontoTotal.setText(Float.toString(montoTotal));
    }
    
    public void limpieTablaDeProductos(){
        DefaultTableModel model = (DefaultTableModel)tablaProductosEncontrados.getModel();
        while(model.getRowCount() != 0)
            model.removeRow(0);
    }
        
    public void agregueProductoATabla(String nom, String cat, String desc, int stockActual, float precioVenta){  
            tablaProductosEncontrados.addRow(new Object[]{nom, cat, desc, stockActual, precioVenta});
    }
    public void agregueItemVenta(String nombre, int cantidad, float precioUnidad, float importeTotal) {
            tablaItems.addRow(new Object[]{nombre, cantidad, precioUnidad, importeTotal});
    }
    
    public void elimineItemVenta(int filaSeleccionada) {
        DefaultTableModel model = (DefaultTableModel)tablaItems.getModel();
        model.removeRow(filaSeleccionada);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        panelBuscadorProds = new javax.swing.JPanel();
        tituloPanelBuscador = new javax.swing.JLabel();
        promptSucursal = new javax.swing.JLabel();
        campoSucursal = new javax.swing.JComboBox<>();
        promptNombreProd = new javax.swing.JLabel();
        campoNombreProd = new javax.swing.JTextField();
        botonBuscar = new interfaz.raven.swing.Button();
        scrollTablaProductos = new javax.swing.JScrollPane();
        tablaProductosEncontrados = new interfaz.raven.swing.table.Table();
        promptUnidades = new javax.swing.JLabel();
        campoCantidad = new javax.swing.JTextField();
        botonAgregarItem = new interfaz.raven.swing.Button();
        errorNombreProducto = new javax.swing.JLabel();
        errorCantidad = new javax.swing.JLabel();
        panelItemsAgregados = new javax.swing.JPanel();
        tituloItemsAgregados = new javax.swing.JLabel();
        indicadorMontoTotal = new javax.swing.JLabel();
        campoMontoTotal = new javax.swing.JTextField();
        signoPeso = new javax.swing.JLabel();
        botonEliminarItem = new interfaz.raven.swing.Button();
        scrollTablaItems = new javax.swing.JScrollPane();
        tablaItems = new interfaz.raven.swing.table.Table();
        errorTablaItems = new javax.swing.JLabel();
        panelDatosPago = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoApellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        campoMetodoPago = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        campoEnvioGratis = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        errorNombre = new javax.swing.JLabel();
        errorApellido = new javax.swing.JLabel();
        campoVentaConReserva = new javax.swing.JCheckBox();
        panelDatosReserva = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        promptSeña = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        errorTelefonoCliente = new javax.swing.JLabel();
        errorSeña = new javax.swing.JLabel();
        campoCodArea = new javax.swing.JTextField();
        campoNumeroTelefono = new javax.swing.JTextField();
        campoSeña = new javax.swing.JTextField();
        panelTitulo = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        panelBotonRegistrar = new javax.swing.JPanel();
        botonRegistrarVenta = new interfaz.raven.swing.Button();
        avisoMirarArriba = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelBuscadorProds.setBackground(new java.awt.Color(255, 251, 251));
        panelBuscadorProds.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tituloPanelBuscador.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        tituloPanelBuscador.setText("BUSCADOR DE PRODUCTOS");

        promptSucursal.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        promptSucursal.setText("Sucursal donde se realiza la venta");

        campoSucursal.setForeground(new java.awt.Color(241, 255, 255));

        promptNombreProd.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        promptNombreProd.setText("Nombre del producto a buscar");

        botonBuscar.setBackground(new java.awt.Color(255, 153, 153));
        botonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscar.setText("BUSCAR");
        botonBuscar.setToolTipText("");
        botonBuscar.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        scrollTablaProductos.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N

        tablaProductosEncontrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "CATEGORÍA", "DESCRIPCIÓN", "STOCK ACTUAL", "PRECIO VENTA"
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
        tablaProductosEncontrados.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        tablaProductosEncontrados.getTableHeader().setReorderingAllowed(false);
        scrollTablaProductos.setViewportView(tablaProductosEncontrados);

        promptUnidades.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        promptUnidades.setText("Unidades a vender");

        botonAgregarItem.setBackground(new java.awt.Color(238, 156, 167));
        botonAgregarItem.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarItem.setText("AGREGAR ITEM DE VENTA");
        botonAgregarItem.setToolTipText("");
        botonAgregarItem.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        botonAgregarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarItemActionPerformed(evt);
            }
        });

        errorNombreProducto.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        errorNombreProducto.setForeground(new java.awt.Color(255, 51, 51));
        errorNombreProducto.setText("El nombre debe tener entre 1 y 80 caracteres");

        errorCantidad.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        errorCantidad.setForeground(new java.awt.Color(255, 51, 51));
        errorCantidad.setText("Error de formato");

        javax.swing.GroupLayout panelBuscadorProdsLayout = new javax.swing.GroupLayout(panelBuscadorProds);
        panelBuscadorProds.setLayout(panelBuscadorProdsLayout);
        panelBuscadorProdsLayout.setHorizontalGroup(
            panelBuscadorProdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscadorProdsLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelBuscadorProdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBuscadorProdsLayout.createSequentialGroup()
                        .addComponent(promptUnidades)
                        .addGap(18, 18, 18)
                        .addComponent(errorCantidad))
                    .addComponent(scrollTablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBuscadorProdsLayout.createSequentialGroup()
                        .addGroup(panelBuscadorProdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoSucursal, 0, 289, Short.MAX_VALUE)
                            .addComponent(promptSucursal)
                            .addComponent(tituloPanelBuscador)
                            .addComponent(campoNombreProd))
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBuscadorProdsLayout.createSequentialGroup()
                        .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonAgregarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBuscadorProdsLayout.createSequentialGroup()
                        .addComponent(promptNombreProd)
                        .addGap(18, 18, 18)
                        .addComponent(errorNombreProducto)))
                .addGap(50, 50, 50))
        );
        panelBuscadorProdsLayout.setVerticalGroup(
            panelBuscadorProdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscadorProdsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tituloPanelBuscador)
                .addGap(30, 30, 30)
                .addComponent(promptSucursal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBuscadorProdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(promptNombreProd)
                    .addComponent(errorNombreProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBuscadorProdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBuscadorProdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(promptUnidades)
                    .addComponent(errorCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBuscadorProdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        panelItemsAgregados.setBackground(new java.awt.Color(247, 255, 247));
        panelItemsAgregados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tituloItemsAgregados.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        tituloItemsAgregados.setText("ITEMS DE VENTA AGREGADOS");

        indicadorMontoTotal.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        indicadorMontoTotal.setText("Monto total");

        campoMontoTotal.setEditable(false);
        campoMontoTotal.setBackground(new java.awt.Color(255, 255, 255));

        signoPeso.setText("$");

        botonEliminarItem.setBackground(new java.awt.Color(0, 204, 51));
        botonEliminarItem.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminarItem.setText("ELIMINAR ITEM SELECCIONADO\n");
        botonEliminarItem.setToolTipText("");
        botonEliminarItem.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        botonEliminarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarItemActionPerformed(evt);
            }
        });

        tablaItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "CANTIDAD", "PRECIO x UNIDAD", "PRECIO x PRODUCTO"
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
        scrollTablaItems.setViewportView(tablaItems);

        errorTablaItems.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        errorTablaItems.setForeground(new java.awt.Color(255, 51, 51));
        errorTablaItems.setText("Tiene que agregar al menos un item de venta");

        javax.swing.GroupLayout panelItemsAgregadosLayout = new javax.swing.GroupLayout(panelItemsAgregados);
        panelItemsAgregados.setLayout(panelItemsAgregadosLayout);
        panelItemsAgregadosLayout.setHorizontalGroup(
            panelItemsAgregadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelItemsAgregadosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelItemsAgregadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(indicadorMontoTotal)
                    .addGroup(panelItemsAgregadosLayout.createSequentialGroup()
                        .addComponent(tituloItemsAgregados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(errorTablaItems))
                    .addComponent(botonEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelItemsAgregadosLayout.createSequentialGroup()
                        .addComponent(signoPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollTablaItems, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        panelItemsAgregadosLayout.setVerticalGroup(
            panelItemsAgregadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelItemsAgregadosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelItemsAgregadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloItemsAgregados)
                    .addComponent(errorTablaItems))
                .addGap(30, 30, 30)
                .addComponent(indicadorMontoTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelItemsAgregadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signoPeso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTablaItems, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        panelDatosPago.setBackground(new java.awt.Color(255, 251, 251));
        panelDatosPago.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel4.setText("DATOS DE PAGO Y DEL CLIENTE");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel3.setText("Nombre del cliente");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel6.setText("Apellido del cliente");

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel8.setText("Método de pago");

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel7.setText("¿La venta es con envío gratis?");

        campoEnvioGratis.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        campoEnvioGratis.setText("Clickee si es así");

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel15.setText("¿La venta es con reserva?");

        errorNombre.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        errorNombre.setForeground(new java.awt.Color(255, 51, 51));
        errorNombre.setText("El nombre debe tener entre 1 y 30 caracteres");

        errorApellido.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        errorApellido.setForeground(new java.awt.Color(255, 51, 51));
        errorApellido.setText("El apellido debe tener entre 1 y 30 caracteres");

        campoVentaConReserva.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        campoVentaConReserva.setText("Clickee si es así");
        campoVentaConReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoVentaConReservaActionPerformed(evt);
            }
        });

        panelDatosReserva.setBackground(new java.awt.Color(255, 204, 204));
        panelDatosReserva.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel1.setText("Teléfono celular del cliente");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel2.setText("Cod. área");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel5.setText("Número");

        promptSeña.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        promptSeña.setText("Seña");

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel10.setText("$");

        errorTelefonoCliente.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        errorTelefonoCliente.setForeground(new java.awt.Color(255, 51, 51));
        errorTelefonoCliente.setText("El código de área debe ser un número");

        errorSeña.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        errorSeña.setForeground(new java.awt.Color(255, 51, 51));
        errorSeña.setText("La seña debe ser mayor a 0");

        javax.swing.GroupLayout panelDatosReservaLayout = new javax.swing.GroupLayout(panelDatosReserva);
        panelDatosReserva.setLayout(panelDatosReservaLayout);
        panelDatosReservaLayout.setHorizontalGroup(
            panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosReservaLayout.createSequentialGroup()
                .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(panelDatosReservaLayout.createSequentialGroup()
                        .addComponent(promptSeña)
                        .addGap(18, 18, 18)
                        .addComponent(errorSeña))
                    .addGroup(panelDatosReservaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5))
                    .addGroup(panelDatosReservaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(errorTelefonoCliente))
                    .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(campoSeña, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosReservaLayout.createSequentialGroup()
                            .addComponent(campoCodArea, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25)
                            .addComponent(campoNumeroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosReservaLayout.setVerticalGroup(
            panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosReservaLayout.createSequentialGroup()
                .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(errorTelefonoCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCodArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNumeroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(promptSeña)
                    .addComponent(errorSeña))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(campoSeña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout panelDatosPagoLayout = new javax.swing.GroupLayout(panelDatosPago);
        panelDatosPago.setLayout(panelDatosPagoLayout);
        panelDatosPagoLayout.setHorizontalGroup(
            panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosPagoLayout.createSequentialGroup()
                        .addComponent(panelDatosReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelDatosPagoLayout.createSequentialGroup()
                        .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoVentaConReserva)
                            .addComponent(campoEnvioGratis)
                            .addComponent(jLabel15)
                            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(errorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(errorApellido))
                            .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoMetodoPago, javax.swing.GroupLayout.Alignment.LEADING, 0, 283, Short.MAX_VALUE)))
                        .addGap(219, 219, 219))))
        );
        panelDatosPagoLayout.setVerticalGroup(
            panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPagoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(errorNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(errorApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoEnvioGratis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoVentaConReserva)
                .addGap(12, 12, 12)
                .addComponent(panelDatosReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        panelTitulo.setOpaque(false);

        jLabel14.setFont(new java.awt.Font("Liberation Serif", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 102, 102));
        jLabel14.setText("REGISTRAR VENTA");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel14)
                .addGap(22, 22, 22))
        );

        panelBotonRegistrar.setOpaque(false);

        botonRegistrarVenta.setBackground(new java.awt.Color(0, 204, 51));
        botonRegistrarVenta.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistrarVenta.setText("REGISTRAR VENTA");
        botonRegistrarVenta.setToolTipText("");
        botonRegistrarVenta.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        botonRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarVentaActionPerformed(evt);
            }
        });

        avisoMirarArriba.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        avisoMirarArriba.setForeground(new java.awt.Color(255, 51, 51));
        avisoMirarArriba.setText("Hay un error! Mire arriba");

        javax.swing.GroupLayout panelBotonRegistrarLayout = new javax.swing.GroupLayout(panelBotonRegistrar);
        panelBotonRegistrar.setLayout(panelBotonRegistrarLayout);
        panelBotonRegistrarLayout.setHorizontalGroup(
            panelBotonRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonRegistrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(461, 461, 461))
            .addGroup(panelBotonRegistrarLayout.createSequentialGroup()
                .addGap(476, 476, 476)
                .addComponent(avisoMirarArriba)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotonRegistrarLayout.setVerticalGroup(
            panelBotonRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonRegistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avisoMirarArriba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelBotonRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelItemsAgregados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBuscadorProds, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelDatosPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBuscadorProds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(panelItemsAgregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(panelDatosPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // Construir objeto producto:
        String nombreProducto = campoNombreProd.getText();
        // Invocar a lógica de la acción.
        logica.usuarioBuscaProducto(nombreProducto, 1, "San Luis");
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonAgregarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarItemActionPerformed
        boolean datosValidos = true;
        int cantidadAVender = 0;
        int filaSeleccionada = -1;
        DefaultTableModel modelo;

        // Obtenemos el modelo de la tabla de items.
        modelo = (DefaultTableModel)tablaProductosEncontrados.getModel();
        // Obtenemos la fila seleccionada.
        filaSeleccionada = tablaProductosEncontrados.getSelectedRow();

        // Ocultamos el cartel de error
        errorCantidad.setText(" ");

        // Validamos que campoCantidad pueda transformarse a int.
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
        // entonces invocamos a la lógica de la acción.
        logica.usuarioQuiereAgregarItem(filaSeleccionada, cantidadAVender);
    }//GEN-LAST:event_botonAgregarItemActionPerformed

    private void botonEliminarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarItemActionPerformed
       DefaultTableModel model;
       int filaSeleccionada = -1; 
        // Obtener modelo de tabla de items.
        model = (DefaultTableModel)tablaItems.getModel();
       // Obtener fila seleccionada de tabla.
       filaSeleccionada = tablaItems.getSelectedRow();
       // Si hay una fila seleccionada,
       if(filaSeleccionada >= 0)
       {
           // entonces invocamos la lógica de la acción. 
           logica.usuarioQuiereEliminarItem(filaSeleccionada);
       }    
    }//GEN-LAST:event_botonEliminarItemActionPerformed

    private void botonRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarVentaActionPerformed
        String nomCliente, apeCliente, strMetodoPago, ubiSucursal, 
                codArea = "INVALIDO", numeroTelefono = "INVALIDO";
        boolean envioGratis, ventaConReserva, datosValidos = true; 
        float seña = -1;  
        
        // Ocultamos carteles de error antiguos.
        this.escondaTodosLosCartelesDeError(); 
        
        // Obtenemos si la venta es con reserva.
        ventaConReserva = campoVentaConReserva.isSelected(); 
        // Si la venta es con reserva,
        if(ventaConReserva){
            // entonces obtenemos el telefono del cliente.
            codArea = campoCodArea.getText();
            numeroTelefono = campoNumeroTelefono.getText();
            // También obtenemos la seña. Validamos que esté en el formato correcto. 
           try
            {
                seña = Float.parseFloat(campoSeña.getText());
            }
            catch (NumberFormatException e)
            {
                errorSeña.setText("La seña debe ser un número");
                datosValidos = false;
            }
        }
        
        if(datosValidos){
            // Obtenemos los datos de pago y del cliente, 
            nomCliente = campoNombre.getText();
            apeCliente = campoApellido.getText();
            strMetodoPago = campoMetodoPago.getSelectedItem().toString();
            ubiSucursal = campoSucursal.getSelectedItem().toString();
            envioGratis = campoEnvioGratis.isSelected();
            
            // e invocamos a la lógica de la acción. 
            logica.usuarioQuiereCompletarVenta(nomCliente, apeCliente, envioGratis , strMetodoPago, 1, ubiSucursal, 
                    ventaConReserva, codArea,  numeroTelefono, seña);
        }
    }//GEN-LAST:event_botonRegistrarVentaActionPerformed

    private void campoVentaConReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoVentaConReservaActionPerformed
        panelDatosReserva.setVisible(!panelDatosReserva.isVisible());
        panelQueMeContiene.bajaScroll();
    }//GEN-LAST:event_campoVentaConReservaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avisoMirarArriba;
    private interfaz.raven.swing.Button botonAgregarItem;
    private interfaz.raven.swing.Button botonBuscar;
    private interfaz.raven.swing.Button botonEliminarItem;
    private interfaz.raven.swing.Button botonRegistrarVenta;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoCantidad;
    private javax.swing.JTextField campoCodArea;
    private javax.swing.JCheckBox campoEnvioGratis;
    private javax.swing.JComboBox<String> campoMetodoPago;
    private javax.swing.JTextField campoMontoTotal;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoNombreProd;
    private javax.swing.JTextField campoNumeroTelefono;
    private javax.swing.JTextField campoSeña;
    private javax.swing.JComboBox<String> campoSucursal;
    private javax.swing.JCheckBox campoVentaConReserva;
    private javax.swing.JLabel errorApellido;
    private javax.swing.JLabel errorCantidad;
    private javax.swing.JLabel errorNombre;
    private javax.swing.JLabel errorNombreProducto;
    private javax.swing.JLabel errorSeña;
    private javax.swing.JLabel errorTablaItems;
    private javax.swing.JLabel errorTelefonoCliente;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel indicadorMontoTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel panelBotonRegistrar;
    private javax.swing.JPanel panelBuscadorProds;
    private javax.swing.JPanel panelDatosPago;
    private javax.swing.JPanel panelDatosReserva;
    private javax.swing.JPanel panelItemsAgregados;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JLabel promptNombreProd;
    private javax.swing.JLabel promptSeña;
    private javax.swing.JLabel promptSucursal;
    private javax.swing.JLabel promptUnidades;
    private javax.swing.JScrollPane scrollTablaItems;
    private javax.swing.JScrollPane scrollTablaProductos;
    private javax.swing.JLabel signoPeso;
    private interfaz.raven.swing.table.Table tablaItems;
    private interfaz.raven.swing.table.Table tablaProductosEncontrados;
    private javax.swing.JLabel tituloItemsAgregados;
    private javax.swing.JLabel tituloPanelBuscador;
    // End of variables declaration//GEN-END:variables
}
