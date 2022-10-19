
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
        
        setOpaque(false);
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
        checkDisponibilidadSanLuis = new javax.swing.JCheckBox();
        panelDatosSanLuis = new javax.swing.JPanel();
        labelPrecioSanLuis = new javax.swing.JLabel();
        campoPrecioSanLuis = new javax.swing.JTextField();
        labelStockSanLuis = new javax.swing.JLabel();
        labelStockMinimoSanLuis = new javax.swing.JLabel();
        campoStockSanLuis = new javax.swing.JTextField();
        campoStockMinimoSanLuis = new javax.swing.JTextField();
        labelOpcionalStockMinimoSanLuis = new javax.swing.JLabel();
        cartelPrecioInvalidoSanLuis = new javax.swing.JLabel();
        cartelStockInvalidoSanLuis = new javax.swing.JLabel();
        cartelStockMinimoInvalidoSanLuis = new javax.swing.JLabel();
        checkDisponibilidadNeuquen = new javax.swing.JCheckBox();
        labelOpcionalDescripcion = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        botonAceptar = new interfaz.raven.swing.Button();
        cartelNombreInvalido = new javax.swing.JLabel();
        campoDescripcion = new javax.swing.JTextField();
        cartelNingunaDisponibilidad = new javax.swing.JLabel();
        panelDatosNeuquen = new javax.swing.JPanel();
        labelPrecioNeuquen = new javax.swing.JLabel();
        campoPrecioNeuquen = new javax.swing.JTextField();
        labelStockNeuquen = new javax.swing.JLabel();
        labelStockMinimoNeuquen = new javax.swing.JLabel();
        campoStockNeuquen = new javax.swing.JTextField();
        campoStockMinimoNeuquen = new javax.swing.JTextField();
        labelOpcionalStockMinimoNeuquen = new javax.swing.JLabel();
        cartelPrecioInvalidoNeuquen = new javax.swing.JLabel();
        cartelStockInvalidoNeuquen = new javax.swing.JLabel();
        cartelStockMinimoInvalidoNeuquen = new javax.swing.JLabel();
        panelTituloFormulario = new javax.swing.JPanel();
        tituloFormulario = new javax.swing.JLabel();

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

        panelContenidoFormulario.setBackground(new java.awt.Color(255, 255, 255));

        labelNombre.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelNombre.setText("Nombre");

        labelCategoria.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelCategoria.setText("Categoría");

        labelDescripcion.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelDescripcion.setText("Descripción");

        campoCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accesorio", "Lencería", "Marroquinería", "Papelería", "Varios" }));
        campoCategoria.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

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

        labelStockMinimoSanLuis.setText("Stock mínimo");

        labelOpcionalStockMinimoSanLuis.setForeground(new java.awt.Color(102, 102, 102));
        labelOpcionalStockMinimoSanLuis.setText("(opcional)");

        cartelPrecioInvalidoSanLuis.setForeground(new java.awt.Color(255, 0, 0));
        cartelPrecioInvalidoSanLuis.setText("Precio inválido");

        cartelStockInvalidoSanLuis.setForeground(new java.awt.Color(255, 0, 0));
        cartelStockInvalidoSanLuis.setText("Cantidad inválida");

        cartelStockMinimoInvalidoSanLuis.setForeground(new java.awt.Color(255, 0, 0));
        cartelStockMinimoInvalidoSanLuis.setText("Cantidad inválida");

        javax.swing.GroupLayout panelDatosSanLuisLayout = new javax.swing.GroupLayout(panelDatosSanLuis);
        panelDatosSanLuis.setLayout(panelDatosSanLuisLayout);
        panelDatosSanLuisLayout.setHorizontalGroup(
            panelDatosSanLuisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosSanLuisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosSanLuisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPrecioSanLuis)
                    .addComponent(labelStockSanLuis)
                    .addGroup(panelDatosSanLuisLayout.createSequentialGroup()
                        .addComponent(labelStockMinimoSanLuis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelOpcionalStockMinimoSanLuis)))
                .addGap(18, 18, 18)
                .addGroup(panelDatosSanLuisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoStockSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoStockMinimoSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPrecioSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosSanLuisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cartelStockInvalidoSanLuis)
                    .addComponent(cartelPrecioInvalidoSanLuis)
                    .addComponent(cartelStockMinimoInvalidoSanLuis))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosSanLuisLayout.setVerticalGroup(
            panelDatosSanLuisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosSanLuisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosSanLuisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrecioSanLuis)
                    .addComponent(campoPrecioSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartelPrecioInvalidoSanLuis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosSanLuisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStockSanLuis)
                    .addComponent(campoStockSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartelStockInvalidoSanLuis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosSanLuisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoStockMinimoSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelOpcionalStockMinimoSanLuis)
                    .addComponent(labelStockMinimoSanLuis)
                    .addComponent(cartelStockMinimoInvalidoSanLuis))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        checkDisponibilidadNeuquen.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        checkDisponibilidadNeuquen.setText("Disponible en Neuquén");
        checkDisponibilidadNeuquen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDisponibilidadNeuquenActionPerformed(evt);
            }
        });

        labelOpcionalDescripcion.setBackground(new java.awt.Color(153, 153, 153));
        labelOpcionalDescripcion.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelOpcionalDescripcion.setForeground(new java.awt.Color(102, 102, 102));
        labelOpcionalDescripcion.setText("(opcional)");

        botonAceptar.setBackground(new java.awt.Color(51, 255, 102));
        botonAceptar.setForeground(new java.awt.Color(255, 255, 255));
        botonAceptar.setText("Aceptar");
        botonAceptar.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        cartelNombreInvalido.setForeground(new java.awt.Color(255, 0, 0));
        cartelNombreInvalido.setText("Nombre inválido");

        cartelNingunaDisponibilidad.setForeground(new java.awt.Color(255, 0, 0));
        cartelNingunaDisponibilidad.setText("El producto debe estar disponible en al menos una sucursal");

        panelDatosNeuquen.setOpaque(false);

        labelPrecioNeuquen.setText("Precio de venta");

        labelStockNeuquen.setText("Stock actual");

        labelStockMinimoNeuquen.setText("Stock mínimo");

        labelOpcionalStockMinimoNeuquen.setForeground(new java.awt.Color(102, 102, 102));
        labelOpcionalStockMinimoNeuquen.setText("(opcional)");

        cartelPrecioInvalidoNeuquen.setForeground(new java.awt.Color(255, 0, 0));
        cartelPrecioInvalidoNeuquen.setText("Precio inválido");

        cartelStockInvalidoNeuquen.setForeground(new java.awt.Color(255, 0, 0));
        cartelStockInvalidoNeuquen.setText("Cantidad inválida");

        cartelStockMinimoInvalidoNeuquen.setForeground(new java.awt.Color(255, 0, 0));
        cartelStockMinimoInvalidoNeuquen.setText("Cantidad inválida");

        javax.swing.GroupLayout panelDatosNeuquenLayout = new javax.swing.GroupLayout(panelDatosNeuquen);
        panelDatosNeuquen.setLayout(panelDatosNeuquenLayout);
        panelDatosNeuquenLayout.setHorizontalGroup(
            panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosNeuquenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPrecioNeuquen)
                    .addComponent(labelStockNeuquen)
                    .addGroup(panelDatosNeuquenLayout.createSequentialGroup()
                        .addComponent(labelStockMinimoNeuquen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelOpcionalStockMinimoNeuquen)))
                .addGap(18, 18, 18)
                .addGroup(panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoStockNeuquen, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoStockMinimoNeuquen, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPrecioNeuquen, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cartelStockInvalidoNeuquen)
                    .addComponent(cartelPrecioInvalidoNeuquen)
                    .addComponent(cartelStockMinimoInvalidoNeuquen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosNeuquenLayout.setVerticalGroup(
            panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosNeuquenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrecioNeuquen)
                    .addComponent(campoPrecioNeuquen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartelPrecioInvalidoNeuquen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStockNeuquen)
                    .addComponent(campoStockNeuquen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartelStockInvalidoNeuquen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosNeuquenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoStockMinimoNeuquen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelOpcionalStockMinimoNeuquen)
                    .addComponent(labelStockMinimoNeuquen)
                    .addComponent(cartelStockMinimoInvalidoNeuquen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelContenidoFormularioLayout = new javax.swing.GroupLayout(panelContenidoFormulario);
        panelContenidoFormulario.setLayout(panelContenidoFormularioLayout);
        panelContenidoFormularioLayout.setHorizontalGroup(
            panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoFormularioLayout.createSequentialGroup()
                .addGroup(panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenidoFormularioLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelContenidoFormularioLayout.createSequentialGroup()
                                .addComponent(labelDescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelOpcionalDescripcion))
                            .addGroup(panelContenidoFormularioLayout.createSequentialGroup()
                                .addGroup(panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelContenidoFormularioLayout.createSequentialGroup()
                                        .addComponent(cartelNingunaDisponibilidad)
                                        .addGap(130, 130, 130))
                                    .addComponent(separador)
                                    .addGroup(panelContenidoFormularioLayout.createSequentialGroup()
                                        .addGroup(panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenidoFormularioLayout.createSequentialGroup()
                                                .addComponent(labelCategoria)
                                                .addGap(143, 143, 143))
                                            .addGroup(panelContenidoFormularioLayout.createSequentialGroup()
                                                .addComponent(labelNombre)
                                                .addGap(160, 160, 160)))
                                        .addGroup(panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoNombre)
                                            .addComponent(campoCategoria, 0, 295, Short.MAX_VALUE)
                                            .addComponent(campoDescripcion))))
                                .addGap(18, 18, 18)
                                .addComponent(cartelNombreInvalido))
                            .addGroup(panelContenidoFormularioLayout.createSequentialGroup()
                                .addComponent(checkDisponibilidadNeuquen)
                                .addGap(40, 40, 40)
                                .addComponent(panelDatosNeuquen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelContenidoFormularioLayout.createSequentialGroup()
                                .addComponent(checkDisponibilidadSanLuis)
                                .addGap(43, 43, 43)
                                .addComponent(panelDatosSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelContenidoFormularioLayout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelContenidoFormularioLayout.setVerticalGroup(
            panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoFormularioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartelNombreInvalido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCategoria)
                    .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOpcionalDescripcion)
                    .addComponent(labelDescripcion)
                    .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartelNingunaDisponibilidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosSanLuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkDisponibilidadSanLuis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelContenidoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkDisponibilidadNeuquen)
                    .addComponent(panelDatosNeuquen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        panelTituloFormulario.setBackground(new java.awt.Color(238, 156, 167));

        tituloFormulario.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        tituloFormulario.setForeground(new java.awt.Color(255, 255, 255));
        tituloFormulario.setText("Registrar Producto");

        javax.swing.GroupLayout panelTituloFormularioLayout = new javax.swing.GroupLayout(panelTituloFormulario);
        panelTituloFormulario.setLayout(panelTituloFormularioLayout);
        panelTituloFormularioLayout.setHorizontalGroup(
            panelTituloFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloFormularioLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(tituloFormulario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloFormularioLayout.setVerticalGroup(
            panelTituloFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContenidoFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTituloFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTituloFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenidoFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
    private javax.swing.JLabel labelAltaExitosa;
    private javax.swing.JLabel labelAltaFallida;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelOpcionalDescripcion;
    private javax.swing.JLabel labelOpcionalStockMinimoNeuquen;
    private javax.swing.JLabel labelOpcionalStockMinimoSanLuis;
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
    private javax.swing.JSeparator separador;
    private javax.swing.JLabel tituloFormulario;
    // End of variables declaration//GEN-END:variables
}
