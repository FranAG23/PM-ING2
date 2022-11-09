
package interfaz.nuestrosFormularios;

import clasesControl.ControladorConsultarVenta;
import clasesEntidad.ItemVenta;
import clasesEntidad.Producto;
import clasesEntidad.Venta;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class FormularioConsultarVenta extends javax.swing.JPanel {
    
    ControladorConsultarVenta logica; 
    public FormularioConsultarVenta() {
        initComponents();
      //  setOpaque(false);
        logica = new ControladorConsultarVenta(this);
        cartelNoHayResultados.setText(" "); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        partePrincipal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        button1 = new interfaz.raven.swing.Button();
        jSpinner3 = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new interfaz.raven.swing.table.Table();
        cartelNoHayResultados = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new interfaz.raven.swing.table.Table();
        jLabel3 = new javax.swing.JLabel();
        cabeza = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        partePrincipal.setBackground(new java.awt.Color(255, 251, 251));
        partePrincipal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel2.setText("Ingrese fecha");

        button1.setBackground(new java.awt.Color(238, 156, 167));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Aceptar");
        button1.setToolTipText("");
        button1.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jSpinner3.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));
        jSpinner3.setToolTipText("");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Envio Gratis", "Método de Pago", "Importe", "Estado", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.getTableHeader().setReorderingAllowed(false);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        cartelNoHayResultados.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelNoHayResultados.setForeground(new java.awt.Color(255, 51, 51));
        cartelNoHayResultados.setText("No se encontraron ventas!");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel4.setText("BUSCADOR DE VENTAS");

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel7.setText("ITEMS DE VENTA");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Categoria", "Cantidad", "Precio venta (unidad)", "Precio total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
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
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaProductos);

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        jLabel3.setText("(clickee en una venta para ver los items)");

        javax.swing.GroupLayout partePrincipalLayout = new javax.swing.GroupLayout(partePrincipal);
        partePrincipal.setLayout(partePrincipalLayout);
        partePrincipalLayout.setHorizontalGroup(
            partePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partePrincipalLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(partePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(partePrincipalLayout.createSequentialGroup()
                        .addGroup(partePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(partePrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(50, 50, 50))
                    .addGroup(partePrincipalLayout.createSequentialGroup()
                        .addGroup(partePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(partePrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(179, 179, 179))
                            .addGroup(partePrincipalLayout.createSequentialGroup()
                                .addGroup(partePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(partePrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cartelNoHayResultados))
                                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        partePrincipalLayout.setVerticalGroup(
            partePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partePrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addGroup(partePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cartelNoHayResultados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(partePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(partePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        cabeza.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 102, 102));
        jLabel1.setFont(new java.awt.Font("Liberation Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("CONSULTAR VENTA");

        javax.swing.GroupLayout cabezaLayout = new javax.swing.GroupLayout(cabeza);
        cabeza.setLayout(cabezaLayout);
        cabezaLayout.setHorizontalGroup(
            cabezaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabezaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cabezaLayout.setVerticalGroup(
            cabezaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabezaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(partePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cabeza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cabeza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(partePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        int FilaSeleccionada = table1.rowAtPoint(evt.getPoint());
        logica.usuarioQuiereVerMas(FilaSeleccionada);
    }//GEN-LAST:event_table1MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        Date D = (Date) jSpinner3.getValue();
        SimpleDateFormat Dt = new SimpleDateFormat("dd-MM-yyyy");
        Dt.format(D);
        logica.usuarioQuiereBuscarVenta(D);
    }//GEN-LAST:event_button1ActionPerformed
    
    public void insertarInfoProducto(ItemVenta Item, Producto P){  
        Object row[] = new Object[5];
        row[0] = P.getNombre();
        row[1] = P.getCategoria();
        row[2] = Item.getCantidad();
        row[3] = Item.getPrecioUnidad(); 
        row[4] = Item.getPrecioUnidad() * Item.getCantidad();
        tablaProductos.addRow(row);
}
    public void insertarTabla(Venta v){  
        Object row[] = new Object[6];
        row[0] = v.getNombreCliente();
        row[1] = v.getEnvioGratis();
        row[2] = v.getMetodoPago();
        row[3] = v.getImporteTotal();
        row[4] = v.getEstado();
        row[5] = v.getFechaUltimoPago();
        table1.addRow(row);
}
    public void borrarTabla(){
        
        int cant_filas=this.table1.getRowCount();
        if(cant_filas>0){
            for(int i=0 ;i<cant_filas;i++)
            ((DefaultTableModel)this.table1.getModel()).removeRow(0);
        }
    }
    
    public void esconderAvisoNoHayResultados(){
        cartelNoHayResultados.setText(" "); 
    }
    
    public void avisarNoHayResultados(){
        cartelNoHayResultados.setText("No se encontraron ventas!"); 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private interfaz.raven.swing.Button button1;
    private javax.swing.JPanel cabeza;
    private javax.swing.JLabel cartelNoHayResultados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JPanel partePrincipal;
    private interfaz.raven.swing.table.Table tablaProductos;
    private interfaz.raven.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables

    public void borrarTablaProductos() {
       
        int cant_filas=this.tablaProductos.getRowCount();
        if(cant_filas>0){
            for(int i=0 ;i<cant_filas;i++)
            ((DefaultTableModel)this.tablaProductos.getModel()).removeRow(0);
        }
    }
}
