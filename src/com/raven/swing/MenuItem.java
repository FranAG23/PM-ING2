package com.raven.swing;

import com.raven.event.EventMenuSelected;
import com.raven.model.ModelMenu;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import com.raven.event.EventMenuPressed;

/*
    DESCRIPCIÓN

        Esta clase tiene el código que dibuja en pantalla un menú del panel de 
        opciones. Dentro del constructor de la clase 'Menu' se crean  objetos de 
        este tipo.

        Raven intenta implementar el patrón VISTA - MODELO - CONTROLADOR. Esta 
        clase representaría la VISTA de un menú. Los íconos y strings a mostrar 
        por pantalla los obtiene del modelo. 
*/
public class MenuItem extends javax.swing.JPanel {

    // Variable usada para las animaciones. 
    private float alpha;
    
    // Modelo de donde se obtienen los recursos a mostrar por pantalla.
    private ModelMenu menu;
    
    // Si open = true entonces el usuario le hizo click al item y se despliegan 
    // los subitems en pantalla. Si open = false el usuario no puede ver los 
    // subitems. Esta variable la utiliza la clase MenuAnimation para implemen- 
    // tar las animaciones. 
    private boolean open;
    
    // Evento de menú seleccionado. 
    private EventMenuSelected eventSelected;
    
    // Índice con el que identificamos al item de menú. 
    private int index;
    
    public ModelMenu getMenu() {
        return menu;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public EventMenuSelected getEventSelected() {
        return eventSelected;
    }

    public void setEventSelected(EventMenuSelected eventSelected) {
        this.eventSelected = eventSelected;
    }

    public int getIndex() {
        return index;
    }

    public MenuItem(ModelMenu menu, EventMenuPressed event, 
                    EventMenuSelected eventSelected, int index) 
    {
        initComponents();
        this.menu = menu;
        this.eventSelected = eventSelected;
        this.index = index;
        
        // Si el panel fuera opaco no podríamos ver el gráfico del botón. 
        setOpaque(false);
        
        // Setear el diseño del panel. 
        setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", 
                               "[fill, 40!]0[fill, 35!]"));
        
        // Inicializamos el botón del item del menú. Un botón tiene un icono y 
        // un nombre, representado con un string. 
        MenuButton firstItem = new MenuButton(menu.getIcon(), 
                                               "      " + menu.getMenuName());
        
        // Agregamos un 'listener' que detecta las acciones que se toman sobre 
        // el botón vigilado. Cuando se detecta una acción se realizan las 
        // acciones codificadas a  continuación. 
        firstItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Si el menú seleccionado tiene al menos un submenú:
                if (menu.getSubMenu().length > 0) {
                    
                    // Enviar evento de que el menú fue presionado. La implemen-
                    // tación de este método se encuentra en la clase Menú.
                    // Si el panel de menús está desplegado en pantalla,
                    if (event.menuPressed(MenuItem.this, !open)) {
                        
                        // entonces indicar que el menú se abrió/cerró. 
                        open = !open;
                    }
                }
                
                // Envíar el evento de que el menú corriente fue seleccionado 
                // pero todavía no se selecciona un submenú. El código que
                // atiende este evento se encuentra en la clase Main. 
                eventSelected.menuSelected(index, -1);
            }
        });
        
        // Agrega botón del menú al panel. 
        add(firstItem);
        
        int subMenuIndex = -1;
        
        // Para cada submenú: 
        for (String st : menu.getSubMenu()) {
            // Crear el botón que representa al submenú.
            MenuButton item = new MenuButton(st);
            
            // Setear índice que identifica al submenú. 
            item.setIndex(++subMenuIndex);
            
            // Agregamos un 'listener' que detecta las acciones que se toman 
            // sobre el botón vigilado. Cuando se detecta una acción se ejecuta
            // el método actionPerformed. 
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    
                    // Envíar que el submenú corriente fue seleccionado. 
                    // El código que atiende este evento se encuentra en 
                    // la clase Main.
                    eventSelected.menuSelected(index, item.getIndex());
                }
            });
            
            // Agregar botón al panel. 
            add(item);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    // Este método pinta al menú en pantalla. Si quisieramos cambiar los gráfi-
    // cos del menú tenemos que tocar este método. 
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getPreferredSize().height;
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(50, 50, 50));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.fillRect(0, 2, width, 38);
        g2.setComposite(AlphaComposite.SrcOver);
        g2.fillRect(0, 40, width, height - 40);
        g2.setColor(new Color(100, 100, 100));
        g2.drawLine(30, 40, 30, height - 17);
        for (int i = 0; i < menu.getSubMenu().length; i++) {
            int y = ((i + 1) * 35 + 40) - 17;
            g2.drawLine(30, y, 38, y);
        }
        if (menu.getSubMenu().length > 0) {
            createArrowButton(g2);
        }
        super.paintComponent(grphcs);
    }

    // Este método pinta la flecha que vemos a la derecha de cada menú. Si 
    // quisieramos cambiar los gráficos de la flecha tenemos que tocar este 
    // método. 
    private void createArrowButton(Graphics2D g2) {
        int size = 4;
        int y = 19;
        int x = 205;
        g2.setColor(new Color(230, 230, 230));
        float ay = alpha * size;
        float ay1 = (1f - alpha) * size;
        g2.drawLine(x, (int) (y + ay), x + 4, (int) (y + ay1));
        g2.drawLine(x + 4, (int) (y + ay1), x + 8, (int) (y + ay));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
