package com.raven.component;

import com.raven.event.EventMenuPressed;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.model.ModelMenu;
import com.raven.swing.MenuAnimation;
import com.raven.swing.MenuItem;
import com.raven.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    
    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    public Menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
      //  profile1.escalarImagen();
    }

    // Método invocado por la clase Main para agregar los menús. Si queremos 
    // cambiar el nombre o imágen de un menú hay que tocar este método.
    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/imagenes/14.png")), "Home"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/imagenes/7.png")), "Productos", "Registrar Producto","Consultar Producto"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/imagenes/3.png")), "Ventas", "Registrar Venta", "Consultar Venta"));
    }

    // Este método simplemente agrega el menú al panel principal. 
    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event,
                 panel.getComponentCount()), "h 40!");
    }

    private EventMenuPressed getEventMenu() {
        return new EventMenuPressed() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                // Si las animaciones de menú estan habilitadas:
                if (enableMenu) {
                    // Si el panel de menús está desplegado en pantalla: 
                    if (isShowMenu()) {
                        // Si se intenta abrir el menú:
                        if (open) {
                            // Ejecutar animación que abre el menú.
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            // Si no, ejectuar animación que cierra el menú. 
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        // Devolver que el panel de menús se muestra en pantalla. 
                        return true;
                    } else {
                        // Si no, mostrar la componente popup. 
                        eventShowPopup.showPopup(com);
                    }
                }
                // Devolver que el panel de menús está escondido. 
                return false;
            }
        };
    }

    // Este método es invocado por la clase Main, y ocurre cuando el usuario
    // aprieta el botón para esconder el panel de menús. Pliega cada menú que
    // se encuentre abierto. 
    public void hideallMenu() {
        // Para cada componente del panel:
        for (Component com : panel.getComponents()) {
            // transformarlo a un objeto del tipo MenuItem.
            MenuItem item = (MenuItem) com;
            // Si el menú está abierto,
            if (item.isOpen()) {
                // entonces ejecutar la animación de plegado.
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        profile1 = new com.raven.component.Profile();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setViewportBorder(null);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    // Este método pinta al panel de opciones en pantalla. Si quisieramos 
    // cambiar el color del panel tenemos que tocar este método.
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        
        // El método setRenderingHint() cambia el renderizado del objeto. 
        // La configuración ANTIALIASING_ON indica que queremos gráficos "suaves". 
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                           RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Con este objeto pintamos el objeto con un color degradado. Para obte-
        // ner colores degradados ir al siguiente link: https://uigradients.com/#ClearSky
        // Escribir los códigos en los campos Color.decode(). 
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#cba09a"), 0, getHeight(), Color.decode("#ee9ca7"));  
        // En el código original de Raven aparece esta sentencia:
        // GradientPaint gra = new GradientPaint(0, 0, new Color(33, 105, 249), getWidth(), 0, new Color(93, 58, 196));
       
        g2.setPaint(g);
        
        // Pinta al objeto con el color actual de g2. 
        g2.fillRect(0, 0, getWidth(), getHeight());
        profile1.escalarImagen();
        super.paintComponent(grphcs);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private com.raven.component.Profile profile1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
