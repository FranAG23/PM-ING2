
package interfaz.nuestrosFormularios;

import clasesControl.ControladorAltaProducto;
import clasesEntidad.Disponibilidad;
import clasesEntidad.Producto;
import clasesEntidad.Sucursal;
import java.awt.Component;
import java.util.ArrayList;

public class FormularioAltaProducto extends javax.swing.JPanel {

    public FormularioAltaProducto() {
        initComponents();
        
        // Oscurecer formularios de Disponibilidad
        for (Component c : panelDatosSanLuis.getComponents()) {
            c.setEnabled(false);
        }
        for (Component c : panelDatosNeuquen.getComponents()) {
            c.setEnabled(false);
        }
        
        // Esconder carteles de datos ingresados inválidos
        resetCarteles();
        
        // Oscurecer opciones de disponibilidad en Neuquén
        // (Para esta entrega presentamos el sistema de Marcela)
        checkDisponibilidadNeuquen.setEnabled(false);
        
     //   setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogAltaExitosa = new javax.swing.JDialog();
        panelDialogAltaExitosa = new javax.swing.JPanel();
        labelAltaExitosa = new javax.swing.JLabel();
        botonAltaExitosa = new interfaz.raven.swing.Button();
        dialogAltaFallida = new javax.swing.JDialog();
        panelDialogAltaFallida = new javax.swing.JPanel();
        labelAltaFallida = new javax.swing.JLabel();
        botonAltaFallida = new interfaz.raven.swing.Button();
        panelContenidoFormulario = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelCategoria = new javax.swing.JLabel();
        labelDescripcion = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        campoCategoria = new javax.swing.JComboBox<>();
        cartelNombreInvalido = new javax.swing.JLabel();
        campoDescripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        panelTituloFormulario = new javax.swing.JPanel();
        tituloFormulario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        checkDisponibilidadSanLuis = new javax.swing.JCheckBox();
        panelDatosSanLuis = new javax.swing.JPanel();
        labelPrecioSanLuis = new javax.swing.JLabel();
        campoPrecioSanLuis = new javax.swing.JTextField();
        labelStockSanLuis = new javax.swing.JLabel();
        labelStockMinimoSanLuis = new javax.swing.JLabel();
        campoStockSanLuis = new javax.swing.JTextField();
        campoStockMinimoSanLuis = new javax.swing.JTextField();
        cartelPrecioInvalidoSanLuis = new javax.swing.JLabel();
        cartelStockInvalidoSanLuis = new javax.swing.JLabel();
        cartelStockMinimoInvalidoSanLuis = new javax.swing.JLabel();
        checkDisponibilidadNeuquen = new javax.swing.JCheckBox();
        panelDatosNeuquen = new javax.swing.JPanel();
        labelPrecioNeuquen = new javax.swing.JLabel();
        campoPrecioNeuquen = new javax.swing.JTextField();
        labelStockNeuquen = new javax.swing.JLabel();
        labelStockMinimoNeuquen = new javax.swing.JLabel();
        campoStockNeuquen = new javax.swing.JTextField();
        campoStockMinimoNeuquen = new javax.swing.JTextField();
        cartelPrecioInvalidoNeuquen = new javax.swing.JLabel();
        cartelStockInvalidoNeuquen = new javax.swing.JLabel();
        cartelStockMinimoInvalidoNeuquen = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        botonAceptar = new interfaz.raven.swing.Button();
        cartelNingunaDisponibilidad = new javax.swing.JLabel();

        dialogAltaExitosa.setMinimumSize(new java.awt.Dimension(345, 106));
        dialogAltaExitosa.setUndecorated(true);
        dialogAltaExitosa.setResizable(false);
        dialogAltaExitosa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dialogAltaExitosaFocusLost(evt);
            }
        });
        dialogAltaExitosa.getContentPane().setLayout(null);

        panelDialogAltaExitosa.setBackground(new java.awt.Color(238, 156, 167));

        labelAltaExitosa.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelAltaExitosa.setForeground(new java.awt.Color(255, 255, 255));
        labelAltaExitosa.setText("¡Producto registrado exitosamente!");

        botonAltaExitosa.setText("OK");
        botonAltaExitosa.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        botonAltaExitosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaExitosaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDialogAltaExitosaLayout = new javax.swing.GroupLayout(panelDialogAltaExitosa);
        panelDialogAltaExitosa.setLayout(panelDialogAltaExitosaLayout);
        panelDialogAltaExitosaLayout.setHorizontalGroup(
            panelDialogAltaExitosaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDialogAltaExitosaLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(panelDialogAltaExitosaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDialogAltaExitosaLayout.createSequentialGroup()
                        .addComponent(labelAltaExitosa, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDialogAltaExitosaLayout.createSequentialGroup()
                        .addComponent(botonAltaExitosa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );
        panelDialogAltaExitosaLayout.setVerticalGroup(
            panelDialogAltaExitosaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDialogAltaExitosaLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(labelAltaExitosa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAltaExitosa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        dialogAltaExitosa.getContentPane().add(panelDialogAltaExitosa);
        panelDialogAltaExitosa.setBounds(0, 0, 350, 110);

        dialogAltaFallida.setMinimumSize(new java.awt.Dimension(345, 106));
        dialogAltaFallida.setUndecorated(true);
        dialogAltaFallida.setResizable(false);
        dialogAltaFallida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dialogAltaFallidaFocusLost(evt);
            }
        });
        dialogAltaFallida.getContentPane().setLayout(null);

        panelDialogAltaFallida.setBackground(new java.awt.Color(238, 156, 167));

        labelAltaFallida.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelAltaFallida.setForeground(new java.awt.Color(255, 255, 255));
        labelAltaFallida.setText("Error al registrar el producto!");

        botonAltaFallida.setText("OK");
        botonAltaFallida.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        botonAltaFallida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaFallidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDialogAltaFallidaLayout = new javax.swing.GroupLayout(panelDialogAltaFallida);
        panelDialogAltaFallida.setLayout(panelDialogAltaFallidaLayout);
        panelDialogAltaFallidaLayout.setHorizontalGroup(
            panelDialogAltaFallidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDialogAltaFallidaLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(panelDialogAltaFallidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDialogAltaFallidaLayout.createSequentialGroup()
                        .addComponent(botonAltaFallida, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDialogAltaFallidaLayout.createSequentialGroup()
                        .addComponent(labelAltaFallida, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );
        panelDialogAltaFallidaLayout.setVerticalGroup(
            panelDialogAltaFallidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDialogAltaFallidaLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(labelAltaFallida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAltaFallida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        dialogAltaFallida.getContentPane().add(panelDialogAltaFallida);
        panelDialogAltaFallida.setBounds(0, 0, 350, 110);

        setBackground(new java.awt.Color(255, 255, 255));

        panelContenidoFormulario.setBackground(new java.awt.Color(255, 251, 251));
        panelContenidoFormulario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelNombre.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        labelNombre.setText("Nombre");

        labelCategoria.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        labelCategoria.setText("Categoría");

        labelDescripcion.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        labelDescripcion.setText("Descripción (opcional)");

        campoCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accesorio", "Lencería", "Marroquinería", "Papelería", "Varios" }));
        campoCategoria.setBorder(null);
        campoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCategoriaActionPerformed(evt);
            }
        });

        cartelNombreInvalido.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelNombreInvalido.setForeground(new java.awt.Color(255, 0, 0));
        cartelNombreInvalido.setText("Nombre inválido");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel1.setText("DATOS DEL PRODUCTO");

        javax.swing.GroupLayout panelContenidoFormularioLayout = new javax.swing.GroupLayout(panelContenidoFormulario);
        panelContenidoFormulario.setLayout(panelContenidoFormularioLayout);
        panelContenidoFormularioLayout.setHorizontalGroup(
            panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoFormularioLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelContenidoFormularioLayout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cartelNombreInvalido))
                    .addComponent(jLabel1)
                    .addComponent(labelDescripcion)
                    .addComponent(labelCategoria)
                    .addComponent(campoNombre)
                    .addComponent(campoCategoria, 0, 289, Short.MAX_VALUE)
                    .addComponent(campoDescripcion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContenidoFormularioLayout.setVerticalGroup(
            panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoFormularioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(cartelNombreInvalido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        panelTituloFormulario.setBackground(new java.awt.Color(255, 255, 255));

        tituloFormulario.setFont(new java.awt.Font("Liberation Serif", 1, 36)); // NOI18N
        tituloFormulario.setForeground(new java.awt.Color(255, 102, 102));
        tituloFormulario.setText("REGISTRAR PRODUCTO");

        javax.swing.GroupLayout panelTituloFormularioLayout = new javax.swing.GroupLayout(panelTituloFormulario);
        panelTituloFormulario.setLayout(panelTituloFormularioLayout);
        panelTituloFormularioLayout.setHorizontalGroup(
            panelTituloFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloFormularioLayout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(tituloFormulario)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        panelTituloFormularioLayout.setVerticalGroup(
            panelTituloFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloFormularioLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(tituloFormulario)
                .addGap(22, 22, 22))
        );

        jPanel1.setBackground(new java.awt.Color(247, 255, 247));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel2.setText("DISPONIBILIDADES");

        checkDisponibilidadSanLuis.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        checkDisponibilidadSanLuis.setText("Disponible en San Luis");
        checkDisponibilidadSanLuis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDisponibilidadSanLuisActionPerformed(evt);
            }
        });

        panelDatosSanLuis.setOpaque(false);

        labelPrecioSanLuis.setText("Precio de venta");

        labelStockSanLuis.setText("Stock actual");

        labelStockMinimoSanLuis.setText("Stock mínimo (opcional)");

        cartelPrecioInvalidoSanLuis.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelPrecioInvalidoSanLuis.setForeground(new java.awt.Color(255, 0, 0));
        cartelPrecioInvalidoSanLuis.setText("Precio inválido");

        cartelStockInvalidoSanLuis.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelStockInvalidoSanLuis.setForeground(new java.awt.Color(255, 0, 0));
        cartelStockInvalidoSanLuis.setText("Cantidad inválida");

        cartelStockMinimoInvalidoSanLuis.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelStockMinimoInvalidoSanLuis.setForeground(new java.awt.Color(255, 0, 0));
        cartelStockMinimoInvalidoSanLuis.setText("Cantidad inválida");

        javax.swing.GroupLayout panelDatosSanLuisLayout = new javax.swing.GroupLayout(panelDatosSanLuis);
        panelDatosSanLuis.setLayout(panelDatosSanLuisLayout);
        panelDatosSanLuisLayout.setHorizontalGroup(
            panelDatosSanLuisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosSanLuisLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(labelPrecioSanLuis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartelPrecioInvalidoSanLuis))
            .addComponent(campoStockMinimoSanLuis, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
            .addGroup(panelDatosSanLuisLayout.createSequentialGroup()
                .addComponent(labelStockSanLuis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cartelStockInvalidoSanLuis))
            .addComponent(campoStockSanLuis)
            .addComponent(campoPrecioSanLuis)
            .addGroup(panelDatosSanLuisLayout.createSequentialGroup()
                .addComponent(labelStockMinimoSanLuis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartelStockMinimoInvalidoSanLuis))
        );
        panelDatosSanLuisLayout.setVerticalGroup(
            panelDatosSanLuisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosSanLuisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosSanLuisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrecioSanLuis)
                    .addComponent(cartelPrecioInvalidoSanLuis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoPrecioSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosSanLuisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStockSanLuis)
                    .addComponent(cartelStockInvalidoSanLuis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoStockSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosSanLuisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStockMinimoSanLuis)
                    .addComponent(cartelStockMinimoInvalidoSanLuis))
                .addGap(7, 7, 7)
                .addComponent(campoStockMinimoSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        checkDisponibilidadNeuquen.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        checkDisponibilidadNeuquen.setText("Disponible en Neuquén");
        checkDisponibilidadNeuquen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDisponibilidadNeuquenActionPerformed(evt);
            }
        });

        panelDatosNeuquen.setOpaque(false);

        labelPrecioNeuquen.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        labelPrecioNeuquen.setText("Precio de venta");

        labelStockNeuquen.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        labelStockNeuquen.setText("Stock actual");

        labelStockMinimoNeuquen.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        labelStockMinimoNeuquen.setText("Stock mínimo (opcional)");

        campoStockMinimoNeuquen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoStockMinimoNeuquenActionPerformed(evt);
            }
        });

        cartelPrecioInvalidoNeuquen.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelPrecioInvalidoNeuquen.setForeground(new java.awt.Color(255, 0, 0));
        cartelPrecioInvalidoNeuquen.setText("Precio inválido");

        cartelStockInvalidoNeuquen.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelStockInvalidoNeuquen.setForeground(new java.awt.Color(255, 0, 0));
        cartelStockInvalidoNeuquen.setText("Cantidad inválida");

        cartelStockMinimoInvalidoNeuquen.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelStockMinimoInvalidoNeuquen.setForeground(new java.awt.Color(255, 0, 0));
        cartelStockMinimoInvalidoNeuquen.setText("Cantidad inválida");

        javax.swing.GroupLayout panelDatosNeuquenLayout = new javax.swing.GroupLayout(panelDatosNeuquen);
        panelDatosNeuquen.setLayout(panelDatosNeuquenLayout);
        panelDatosNeuquenLayout.setHorizontalGroup(
            panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosNeuquenLayout.createSequentialGroup()
                .addComponent(labelPrecioNeuquen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cartelPrecioInvalidoNeuquen))
            .addGroup(panelDatosNeuquenLayout.createSequentialGroup()
                .addComponent(labelStockNeuquen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartelStockInvalidoNeuquen))
            .addGroup(panelDatosNeuquenLayout.createSequentialGroup()
                .addComponent(labelStockMinimoNeuquen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartelStockMinimoInvalidoNeuquen))
            .addGroup(panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(campoStockMinimoNeuquen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addComponent(campoStockNeuquen, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(campoPrecioNeuquen, javax.swing.GroupLayout.Alignment.LEADING))
        );
        panelDatosNeuquenLayout.setVerticalGroup(
            panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosNeuquenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrecioNeuquen)
                    .addComponent(cartelPrecioInvalidoNeuquen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoPrecioNeuquen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStockNeuquen)
                    .addComponent(cartelStockInvalidoNeuquen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoStockNeuquen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStockMinimoNeuquen)
                    .addComponent(cartelStockMinimoInvalidoNeuquen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoStockMinimoNeuquen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkDisponibilidadSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelDatosSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDatosNeuquen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkDisponibilidadNeuquen))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkDisponibilidadSanLuis)
                    .addComponent(checkDisponibilidadNeuquen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDatosNeuquen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel3.setOpaque(false);

        botonAceptar.setBackground(new java.awt.Color(0, 204, 51));
        botonAceptar.setForeground(new java.awt.Color(255, 255, 255));
        botonAceptar.setText("ACEPTAR");
        botonAceptar.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        cartelNingunaDisponibilidad.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        cartelNingunaDisponibilidad.setForeground(new java.awt.Color(255, 0, 0));
        cartelNingunaDisponibilidad.setText("El producto debe estar disponible en al menos una sucursal");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cartelNingunaDisponibilidad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartelNingunaDisponibilidad))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelContenidoFormulario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTituloFormulario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTituloFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenidoFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkDisponibilidadSanLuisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDisponibilidadSanLuisActionPerformed
        
        // Disponible en San Luis
        
        if (checkDisponibilidadSanLuis.isSelected()) {
            for (Component c : panelDatosSanLuis.getComponents()) {
                c.setEnabled(true);
            }
        }
        else {
            for (Component c : panelDatosSanLuis.getComponents()) {
                c.setEnabled(false);
            }
            
        }
        
        cartelPrecioInvalidoSanLuis.setVisible(false);
        cartelStockInvalidoSanLuis.setVisible(false);
        cartelStockMinimoInvalidoSanLuis.setVisible(false);
    }//GEN-LAST:event_checkDisponibilidadSanLuisActionPerformed

    private void checkDisponibilidadNeuquenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDisponibilidadNeuquenActionPerformed
        
        // Disponible en Neuquén
        /*
        if (checkDisponibilidadNeuquen.isSelected()) {
            for (Component c : panelDatosNeuquen.getComponents()) {
                c.setEnabled(true);
            }
        }
        else {
            for (Component c : panelDatosNeuquen.getComponents()) {
                c.setEnabled(false);
            }
        }
        
        cartelPrecioInvalidoNeuquen.setVisible(false);
        cartelStockInvalidoNeuquen.setVisible(false);
        cartelStockMinimoInvalidoNeuquen.setVisible(false);
        */
    }//GEN-LAST:event_checkDisponibilidadNeuquenActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        
        // En este método se valida si se tienen los datos necesarios para construir el 
        // Producto que se pasa como parámetro al ManagerProducto. Ahi es donde
        // se comprueba que los datos sean válidos para dar el Producto de alta.
        
        // EN RESUMEN: INTERFAZ VALIDA LA SINTAXIS, MANAGER VALIDA LA SEMÁNTICA
        
        boolean invalido = false;
        String s;
        float precioVentaSanLuis = 0;
        float precioVentaNeuquen = 0;
        int stockActualSanLuis = 0;
        int stockActualNeuquen = 0;
        int stockMinimoSanLuis = 0;
        int stockMinimoNeuquen = 0;
        
        resetCarteles();
        
        if (checkDisponibilidadSanLuis.isSelected()) {
            try {
                s = campoPrecioSanLuis.getText();
                s = s.replace(',', '.');
                precioVentaSanLuis = Float.parseFloat(s);
            } catch (NumberFormatException e) {
                avisarPrecioInvalidoSanLuis();
                invalido = true;
            }
            
            try {
                stockActualSanLuis = Integer.parseInt(campoStockSanLuis.getText());
            } catch (NumberFormatException e) {
                avisarStockInvalidoSanLuis();
                invalido = true;
            }
            
            try {
                if (! campoStockMinimoSanLuis.getText().isBlank()) {
                    stockMinimoSanLuis = Integer.parseInt(campoStockMinimoSanLuis.getText());
                }
            } catch (NumberFormatException e) {
                avisarStockMinimoInvalidoSanLuis();
                invalido = true;
            }
        }
        
        if (checkDisponibilidadNeuquen.isSelected()) {
            try {
                s = campoPrecioNeuquen.getText();
                s = s.replace(',', '.');
                
                precioVentaNeuquen = Float.parseFloat(s);
            } catch (NumberFormatException e) {
                avisarPrecioInvalidoNeuquen();
                invalido = true;
            }
            
            try {
                stockActualNeuquen = Integer.parseInt(campoStockNeuquen.getText());
            } catch (NumberFormatException e) {
                avisarStockInvalidoNeuquen();
                invalido = true;
            }
            
            try {
                if (! campoStockMinimoNeuquen.getText().isBlank()) {
                    stockMinimoNeuquen = Integer.parseInt(campoStockMinimoNeuquen.getText());
                }
            } catch (NumberFormatException e) {
                avisarStockMinimoInvalidoNeuquen();
                invalido = true;
            }
        }
        
        if (! invalido) {
            
            // Crear Producto y enviar al controlador
            
            Producto.CategoriaProducto cat;
            cat = switch (campoCategoria.getSelectedIndex()) {
                case 0 -> Producto.CategoriaProducto.ACCESORIO;
                case 1 -> Producto.CategoriaProducto.LENCERIA;
                case 2 -> Producto.CategoriaProducto.MARROQUINERIA;
                case 3 -> Producto.CategoriaProducto.PAPELERIA;
                default -> Producto.CategoriaProducto.VARIOS;
            };
            
            ArrayList<Disponibilidad> arrd = new ArrayList<>();
            
            if (checkDisponibilidadSanLuis.isSelected()) {
                
                Disponibilidad dsl = new Disponibilidad(    precioVentaSanLuis, 
                                                            stockActualSanLuis, 
                                                            (! campoStockMinimoSanLuis.getText().isBlank()),
                                                            stockMinimoSanLuis,
                                                            new Sucursal("San Luis"),
                                                            new Producto());
                
                arrd.add(dsl);
            }
            
            if (checkDisponibilidadNeuquen.isSelected()) {
                
                Disponibilidad dn = new Disponibilidad( precioVentaNeuquen, 
                                                        stockActualNeuquen, 
                                                        (! campoStockMinimoNeuquen.getText().isBlank()),
                                                        stockMinimoNeuquen,
                                                        new Sucursal("Neuquen"),
                                                        new Producto());
                
                arrd.add(dn);
            }
            
            Producto p = new Producto(  0,
                                        campoNombre.getText(),
                                        campoDescripcion.getText(),
                                        cat,
                                        arrd    );
            
            for (Disponibilidad d : p.getDisponibilidades()) {
                d.setProducto(p);
            }
            
            // Llamar al controlador
            new ControladorAltaProducto(this, p);
        }
        
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonAltaExitosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaExitosaActionPerformed
        dialogAltaExitosa.setVisible(false);
    }//GEN-LAST:event_botonAltaExitosaActionPerformed

    private void dialogAltaExitosaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dialogAltaExitosaFocusLost
        dialogAltaExitosa.setVisible(false);
    }//GEN-LAST:event_dialogAltaExitosaFocusLost

    private void botonAltaFallidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaFallidaActionPerformed
        dialogAltaFallida.setVisible(false);
    }//GEN-LAST:event_botonAltaFallidaActionPerformed

    private void dialogAltaFallidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dialogAltaFallidaFocusLost
        dialogAltaFallida.setVisible(false);
    }//GEN-LAST:event_dialogAltaFallidaFocusLost

    private void campoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCategoriaActionPerformed

    private void campoStockMinimoNeuquenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoStockMinimoNeuquenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoStockMinimoNeuquenActionPerformed

    public void avisarNombreInvalido() {
        
        campoNombre.setText("");
        cartelNombreInvalido.setVisible(true);
    }
    
    public void avisarNingunaDisponibilidad() {
        
        cartelNingunaDisponibilidad.setVisible(true);
    }
    
    public void avisarPrecioInvalidoSanLuis() {
       
        campoPrecioSanLuis.setText("");
        cartelPrecioInvalidoSanLuis.setVisible(true);
    }
    
    public void avisarStockInvalidoSanLuis() {
        
        campoStockSanLuis.setText("");
        cartelStockInvalidoSanLuis.setVisible(true);
    }
    
    public void avisarStockMinimoInvalidoSanLuis() {
       
        campoStockMinimoSanLuis.setText("");
        cartelStockMinimoInvalidoSanLuis.setVisible(true);
    }
    
    public void avisarPrecioInvalidoNeuquen() {
        
        campoPrecioNeuquen.setText("");
        cartelPrecioInvalidoNeuquen.setVisible(true);
    }
    
    public void avisarStockInvalidoNeuquen() {
       
        campoStockNeuquen.setText("");
        cartelStockInvalidoNeuquen.setVisible(true);
    }
    
    public void avisarStockMinimoInvalidoNeuquen() {
       
        campoStockMinimoNeuquen.setText("");
        cartelStockMinimoInvalidoNeuquen.setVisible(true);
    }
    
    public void resetCarteles() {
        
        cartelNombreInvalido.setVisible(false);
        cartelNingunaDisponibilidad.setVisible(false);
        
        cartelPrecioInvalidoSanLuis.setVisible(false);
        cartelStockInvalidoSanLuis.setVisible(false);
        cartelStockMinimoInvalidoSanLuis.setVisible(false);
        
        cartelPrecioInvalidoNeuquen.setVisible(false);
        cartelStockInvalidoNeuquen.setVisible(false);
        cartelStockMinimoInvalidoNeuquen.setVisible(false);
    }
    
    public void resetCampos() {
        
        campoNombre.setText("");
        campoCategoria.setSelectedIndex(0);
        campoDescripcion.setText("");
        campoPrecioSanLuis.setText("");
        campoStockSanLuis.setText("");
        campoStockMinimoSanLuis.setText("");
        campoPrecioNeuquen.setText("");
        campoStockNeuquen.setText("");
        campoStockMinimoNeuquen.setText("");
        
        if (checkDisponibilidadSanLuis.isSelected()) checkDisponibilidadSanLuis.doClick();
        if (checkDisponibilidadNeuquen.isSelected()) checkDisponibilidadNeuquen.doClick();
    }
    
    public void mostrarCartelAltaExitosa() {
        
        dialogAltaExitosa.setLocationRelativeTo(null);
        dialogAltaExitosa.setVisible(true);
    }
    
    public void mostrarCartelAltaFallida() {
        
        dialogAltaFallida.setLocationRelativeTo(null);
        dialogAltaFallida.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private interfaz.raven.swing.Button botonAceptar;
    private interfaz.raven.swing.Button botonAltaExitosa;
    private interfaz.raven.swing.Button botonAltaFallida;
    private javax.swing.JComboBox<String> campoCategoria;
    private javax.swing.JTextField campoDescripcion;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecioNeuquen;
    private javax.swing.JTextField campoPrecioSanLuis;
    private javax.swing.JTextField campoStockMinimoNeuquen;
    private javax.swing.JTextField campoStockMinimoSanLuis;
    private javax.swing.JTextField campoStockNeuquen;
    private javax.swing.JTextField campoStockSanLuis;
    private javax.swing.JLabel cartelNingunaDisponibilidad;
    private javax.swing.JLabel cartelNombreInvalido;
    private javax.swing.JLabel cartelPrecioInvalidoNeuquen;
    private javax.swing.JLabel cartelPrecioInvalidoSanLuis;
    private javax.swing.JLabel cartelStockInvalidoNeuquen;
    private javax.swing.JLabel cartelStockInvalidoSanLuis;
    private javax.swing.JLabel cartelStockMinimoInvalidoNeuquen;
    private javax.swing.JLabel cartelStockMinimoInvalidoSanLuis;
    private javax.swing.JCheckBox checkDisponibilidadNeuquen;
    private javax.swing.JCheckBox checkDisponibilidadSanLuis;
    private javax.swing.JDialog dialogAltaExitosa;
    private javax.swing.JDialog dialogAltaFallida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelAltaExitosa;
    private javax.swing.JLabel labelAltaFallida;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrecioNeuquen;
    private javax.swing.JLabel labelPrecioSanLuis;
    private javax.swing.JLabel labelStockMinimoNeuquen;
    private javax.swing.JLabel labelStockMinimoSanLuis;
    private javax.swing.JLabel labelStockNeuquen;
    private javax.swing.JLabel labelStockSanLuis;
    private javax.swing.JPanel panelContenidoFormulario;
    private javax.swing.JPanel panelDatosNeuquen;
    private javax.swing.JPanel panelDatosSanLuis;
    private javax.swing.JPanel panelDialogAltaExitosa;
    private javax.swing.JPanel panelDialogAltaFallida;
    private javax.swing.JPanel panelTituloFormulario;
    private javax.swing.JLabel tituloFormulario;
    // End of variables declaration//GEN-END:variables
}
