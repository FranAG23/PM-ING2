package interfaz.raven.model;

import javax.swing.Icon;

/*
    DESCRIPCIÓN

        Cada objeto de esta clase es el modelo de algún menú que aparece en el 
        panel de menús de nuestra aplicación. En la arquitectura VISTA-MODELO-CONTROLADOR,
        el modelo tiene la responsabilidad de actualizar las estructuras de datos
        que contienen los objetos a mostrar por pantalla. 

*/

public class ModelMenu {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String[] getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String[] subMenu) {
        this.subMenu = subMenu;
    }

    public ModelMenu(Icon icon, String menuName, String... subMenu) {
        this.icon = icon;
        this.menuName = menuName;
        this.subMenu = subMenu;
    }

    public ModelMenu() {
    }

    private Icon icon;
    private String menuName;
    private String subMenu[];
}
