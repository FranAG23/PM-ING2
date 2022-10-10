package clases_control;
import clases_control.ManagerProducto;
import clases_entidad.Disponibilidad;
import clases_entidad.ItemVenta;
import clases_entidad.Producto;
import clases_entidad.Sucursal;
import clases_entidad.Venta;
import com.raven.form.FormularioAltaVenta;
import dao.DAODisponibilidad;
import dao.DAOProducto;
import dao.DAOVenta;
import java.util.ArrayList;
import java.util.Date;

public class LogicaAltaVenta {
    // Tiene los últimos productos buscados por el cliente.
    ArrayList<Producto> productosBuscados;
    // Tiene los items de venta cargados actualmente por el usuario.
    ArrayList<ItemVenta> itemsCargados; 
    // Interfaz. 
    FormularioAltaVenta formulario;
    // Monto total.
    float importe;
    
    public LogicaAltaVenta(FormularioAltaVenta formulario){
        this.formulario = formulario; 
        itemsCargados = new ArrayList<>();
        productosBuscados = new ArrayList<>();
        importe = 0; 
    }
    
    public void usuarioBuscaProducto(String nombreBuscado, int idsucursal, String ubicacionSucursal){
        DAOProducto daoProducto = new DAOProducto();
        Producto prodBuscado = new Producto();
        Sucursal sucursalDeVenta = new Sucursal();
        Disponibilidad dispProd = new Disponibilidad();
        
        // Esconder mensajes de error antiguo. 
        formulario.esconderCartelesDeError();
        
        // Si el nombre es vacío o tiene una longitud mayor a 30, 
        if(nombreBuscado.isEmpty() || nombreBuscado.length() > 30){
            // mostrar mensaje de error por pantalla. 
            formulario.mostrarErrorBuscadorNombre();
        }        
        else
        {   
            // Si todo está bien, decirle a daoProducto que me obtenga los productos y sus disponibilidades
            // en la sucursal donde trabaja el usuario. 
            prodBuscado.setNombre(nombreBuscado);
            sucursalDeVenta.setID(idsucursal);
            sucursalDeVenta.setUbicacion(ubicacionSucursal);
            productosBuscados = daoProducto.obtenerProdsConDisp(prodBuscado, sucursalDeVenta);
            
            // Si no obtuve ningun producto, 
            if(productosBuscados.isEmpty()){
                // entonces mostrar un cartel de advertencia. 
                formulario.advertirNoHayResultados();
            }
            else
            {
                
                // Si obtuve los resultados que quería, escondemos la búsqueda antigua y mostrados 
                // los nuevos productos y disponibilidades obtenidos.
                formulario.borrarFilasDeProductos();
                for(Producto prod: productosBuscados){
                    // Obtener disponibilidad del producto:
                    dispProd = prod.getDisponibilidades().get(0);
                    // Agregar una nueva fila a la tabla de productos con los datos obtenidos:
                    formulario.agregarFilaDeProducto(prod.getNombre(), prod.getCategoria().toString(), 
                            prod.getDescripcion(), dispProd.getStockActual(), dispProd.getPrecioVenta());
                }
            }
        }   
    }
    
    public void usuarioQuiereAgregarItem(int filaSeleccionada, int cantidad){
        // Esconder mensajes de error antiguos:
        formulario.esconderCartelesDeError();
        
        Producto prod; 
        Disponibilidad disp; 
        ItemVenta item = new ItemVenta(); 
        ArrayList<Disponibilidad> disponibilidades = new ArrayList<>(); 
        boolean repetido = false; 
        int stockActual = 0; 
        float importeProducto = 0;
        // Si el usuario ingresó un numero negativo,
        if(cantidad <= 0)
        { 
            // entonces enviar mensaje de error.
            formulario.advertirCantidadNoPositiva();
        }
        else
        {
            // Obtener producto seleccionado por el usuario. 
            prod = new Producto(productosBuscados.get(filaSeleccionada));
            // Obtener disponibilidad de ese producto. 
            disp = new Disponibilidad(prod.getDisponibilidades().get(0)); 
            // Obtenemos el stock actual del producto.
            stockActual = disp.getStockActual();
            // Si la cantidad a comprar es mayor a la disponibilidad actual,
            if(stockActual < cantidad)
            {
              // entonces enviar mensaje de error por pantalla.
              formulario.indicarQueCantidadSuperaStock();
            }
            else
            {
                // Si todo salió bien, verificar que no haya cargado un item de 
                // venta con el mismo producto.
                for(ItemVenta it: itemsCargados){
                    //Si el nombre del producto de it es igual al nombre del producto que quiero agregar,
                    if(it.getProducto().getNombre().equals(prod.getNombre())){
                        // marcar que el item está repetido.
                        repetido = true; 
                    }
                }
                // Si se encontró un item repetido,
                if(repetido){
                    // entonces indicar un error por pantalla.
                    formulario.advertirItemRepetido();
                }
                else
                {
                    // Si todo salio bien, modificamos el stock del producto. 
                    disp.setStockActual(stockActual - cantidad);
                    
                    // Modificamos disponibilidades.
                    disponibilidades.add(disp); 
                    
                    // Se lo damos al nuevo producto.
                    prod.setDisponibilidades(disponibilidades);
                    //System.out.println("Disponibilidad prod: " +  prod.getDisponibilidades().get(0).getStockActual());
                    // Construimos el item de venta:
                    item.setCantidad(cantidad);
                    item.setPrecioUnidad(disp.getPrecioVenta());
                    item.setProducto(prod);
                    //System.out.println("Disponibilidad prod: " +  item.getProducto().getDisponibilidades().get(0).getStockActual());
                    // Agregarlo a nuestro arreglo. 
                    itemsCargados.add(item); 
                    // Finalmente, mostrar el item de venta por pantalla.
                    importeProducto = cantidad * item.getPrecioUnidad();
                    importe += importeProducto; 
                    formulario.agregarItemVenta(prod.getNombre(), cantidad, item.getPrecioUnidad(), importeProducto);
                } 
            }
        }    
    }
    
    public void usuarioQuiereEliminarItem(int filaSeleccionada, String nombreProducto){
       // Esconder mensajes de error antiguos. 
        formulario.esconderCartelesDeError();
       // Buscar item de venta que quiere eliminar el usuario:
       for(int i = 0; i < itemsCargados.size(); i++){
            // Si coinciden los nombres,
           if(itemsCargados.get(i).getProducto().getNombre().equals(nombreProducto)){
               // entonces lo eliminamos de nuestra lista.
               importe -= itemsCargados.get(i).getPrecioUnidad() * itemsCargados.get(i).getCantidad(); 
               itemsCargados.remove(i);
           }    
       }
       
       // Eliminar item de la tabla que ve el usuario:
       formulario.eliminarFilaItemVenta(filaSeleccionada);
    }
    
    public void usuarioQuiereCompletarVenta(String nomCliente, String apeCliente, boolean envioGratis, 
            String strMetodoPago, int idsucursal, String ubiSucursal){
       DAOVenta daoVenta = new DAOVenta();
       DAODisponibilidad daoDisp = new DAODisponibilidad(); 
       Sucursal sucursal; 
       Disponibilidad disp; 
       Venta venta; 
       Venta.MetodoPago metodoPago; 
       Venta.EstadoVenta estadoVenta;
       boolean datosValidos = true;
       boolean exitoInsercionBD = true; 
      
       // Esconder mensajes de error antiguos:
       formulario.esconderCartelesDeError();
       
       // Si nombre tiene 0 caracteres o más de 30 caracteres,
       if(nomCliente.isEmpty() || nomCliente.length() > 30){
           // entonces enviar mensaje de error.
           formulario.mostrarErrorNombre();
           datosValidos = false; 
       }
       // Si apellido tiene 0 caracteres o más de 30 caracteres,
       if(apeCliente.isEmpty() || apeCliente.length() > 30){
           // entonces enviar mensaje de error
           formulario.mostrarErrorApellido();
           datosValidos = false;
       }
       // Si la lista de items está vacía,
       if(itemsCargados.isEmpty()){
           // entonces enviar mensaje de error. 
           formulario.mostrarErrorTablaVacia();
           datosValidos = false; 
       }
       
       // Si todos los datos son correctos,
       if(datosValidos)
       {
            // entonces construimos los objetos a dar de alta.
           //  Primero construimos la sucursal.
            sucursal = new Sucursal(idsucursal, ubiSucursal);

            // Ahora construimos el objeto venta.
            // Convertimos de string a enumerado. 
            metodoPago = Venta.stringAMetodoPago(strMetodoPago);
            // Hasta que no agreguemos el CU "Alta Reserva", nuestras ventas estarán siempre completas:
            estadoVenta = Venta.EstadoVenta.COMPLETADA;
            // Finalmente el objeto venta es el siguiente. 
            venta = new Venta(-1, nomCliente, apeCliente, envioGratis, importe,  new Date(),
                              metodoPago, estadoVenta, null, itemsCargados, sucursal);

            // Dar de alta venta en Base de datos:
            exitoInsercionBD = daoVenta.registrar(venta);

            // Si la insercion en la BD fue exitosa,
            if(exitoInsercionBD){
                // entonces modificar stock de los productos.
                // Por el momento esta operación es costosa porque abrimos y cerramos la conexión bajo demanda.
                // Luego abriremos y cerraremos la la conexión una sola vez. 
                for(ItemVenta item: venta.getItems()){
                    disp = item.getProducto().getDisponibilidades().get(0);
                    System.out.println("Actualizacion prod: " +  disp.getStockActual());
                    daoDisp.modificar(disp);
                }
                
                // reiniciar campos de la GUI. 
                formulario.reiniciarCampos();
                // entonces mostrar un cartel de éxito.
                formulario.mostrarCartelExito();
                // y prepararse para una nueva venta. 
                this.prepararseParaNuevaVenta();
            }
            else{
                // Si no, mostrar cartel de fracaso.
                formulario.mostrarCartelFracaso();
            }
       }
    }
    
    private void prepararseParaNuevaVenta(){
        // Eliminar todos los items cargados.
        for(int i = 0; i < itemsCargados.size(); i++){
               itemsCargados.remove(i);
        }    
        
        // Eliminar todos los productos buscados.
        for(int i = 0; i < productosBuscados.size(); i++){
               productosBuscados.remove(i);
        }  
        
        // Reiniciar el importe a 0.
        importe = 0; 
    }
}
