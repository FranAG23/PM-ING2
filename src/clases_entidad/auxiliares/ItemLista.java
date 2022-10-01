
package clases_entidad.auxiliares;

// Clase que consiste simplemente de un par int/String. 
// Al hacer consultas a la BD donde se retornan múltiples elementos, no tiene sentido traerlos 
// completos. Primero se le muestra una lista al usuario y él selecciona un elemento para consultar.
// Entonces se necesita algo que mostrar en cada celda de la lista (Este String puede ser un nombre
// de producto, de cliente, fecha de una venta, etc.), y un ID que se usará para buscar un objeto
// específico en la BD y traer sus datos completos.

public class ItemLista {
    
    public int id;
    public String texto;
    
    public ItemLista(int id, String texto) {
        
        this.id = id;
        this.texto = texto;
    }
}
