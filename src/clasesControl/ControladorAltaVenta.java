
package clasesControl;

import clasesEntidad.Disponibilidad;
import clasesEntidad.ItemVenta;
import clasesEntidad.Producto;
import clasesEntidad.Reserva;
import clasesEntidad.Sucursal;
import clasesEntidad.Venta;
import dao.DAODisponibilidad;
import dao.DAOProducto;
import dao.DAOReserva;
import dao.DAOVenta;
import interfaz.nuestrosFormularios.FormularioAltaVenta;
import java.util.ArrayList;
import java.util.Date;

public class ControladorAltaVenta {
    // Tiene los últimos productos buscados por el cliente.
    ArrayList<Producto> productosBuscados;
    // Tiene los items de venta cargados actualmente por el usuario.
    ArrayList<ItemVenta> itemsCargados; 
    // Interfaz. 
    FormularioAltaVenta formulario;
    // Monto total.
    float importeTotal;
    // DAOs.
    DAOVenta daoVenta;
    DAOProducto daoProducto;
    DAODisponibilidad daoDisp; 
    DAOReserva daoReserva; 
    
    public ControladorAltaVenta(FormularioAltaVenta formulario){
        this.formulario = formulario; 
        itemsCargados = new ArrayList<>();
        productosBuscados = new ArrayList<>();
        importeTotal = 0; 
        daoVenta = new DAOVenta();
        daoProducto = new DAOProducto();
        daoDisp = new DAODisponibilidad();
        daoReserva = new DAOReserva(); 
    }
    
    public void usuarioBuscaProducto(String nombreBuscado, int idSucursal, String ubicacionSucursal){
        Disponibilidad dispProd = new Disponibilidad();
        
        // Escondemos mensajes de error antiguos. 
        formulario.escondaTodosLosCartelesDeError();
        
        // Si el nombre es vacío o tiene una longitud mayor a 30, 
        if(nombreBuscado.isEmpty() || nombreBuscado.length() > 30){
            // mostramos mensaje de error por pantalla. 
            formulario.muestreErrorNombreProducto();
        }        
        else
        {   
            // Si todo está bien, le decimos a daoProducto que obtenga los productos y 
            // sus disponibilidades en la sucursal donde trabaja el usuario.
            productosBuscados = daoProducto.obtengaProductosConDisponibilidad(nombreBuscado, new Sucursal(1, "San Luis"));
            
            // Si no obtuvimos ningun producto, 
            if(productosBuscados.isEmpty()){
                // entonces mostramos un cartel de advertencia.
                formulario.adviertaNoHayResultados();
                // También limpiamos la tabla de resultados anterior.
                formulario.limpieTablaDeProductos();
            }
            else
            { 
                // Si obtuvimos los resultados que queríamos, escondemos la búsqueda antigua y mostramos 
                // los nuevos productos y disponibilidades obtenidos.
                formulario.limpieTablaDeProductos();
                for(Producto prod: productosBuscados){
                    // Obtenemos disponibilidad del producto:
                    dispProd = prod.getDisponibilidades().get(0);
                    // Agregamos una nueva fila a la tabla de productos con los datos obtenidos:
                    formulario.agregueProductoATabla(prod.getNombre(), prod.getCategoria().toString(), 
                            prod.getDescripcion(), dispProd.getStockActual(), dispProd.getPrecioVenta());
                }
            }
        }   
    }
    
    public void usuarioQuiereAgregarItem(int filaSeleccionada, int cantidad){
        Producto prod; 
        Disponibilidad disp; 
        ItemVenta item = new ItemVenta(); 
        ArrayList<Disponibilidad> disponibilidades = new ArrayList<>(); 
        boolean repetido = false; 
        int stockActual = 0; 
        float importeProducto = 0;

        // Escondemos mensajes de error antiguos:
        formulario.escondaTodosLosCartelesDeError();
      
        // Si el usuario ingresó un numero negativo,
        if(cantidad <= 0)
        { 
            // entonces enviamos mensaje de error.
            formulario.muestreErrorFormatoCantidad();
        }
        else
        {
            // Obtenemos producto seleccionado por el usuario. 
            prod = new Producto(productosBuscados.get(filaSeleccionada));
            // Obtenemos disponibilidad de ese producto. 
            disp = new Disponibilidad(prod.getDisponibilidades().get(0)); 
            // Obtenemos el stock actual del producto.
            stockActual = disp.getStockActual();
            // Si la cantidad a comprar es mayor a la disponibilidad actual,
            if(stockActual < cantidad)
            {
              // entonces enviamos un mensaje de error por pantalla.
              formulario.muestreErrorCantidadSuperaStock();
            }
            else
            {
                // Si todo salió bien, verificamos que el usuario 
                // no haya cargado un item de venta con el mismo producto.
                for(ItemVenta it: itemsCargados){
                    //Si el id del producto de it es igual al id del producto que quiero agregar,
                     if(it.getProducto().getId() == prod.getId()){
                        // marcamos que el item está repetido.
                        repetido = true; 
                    }
                }
                // Si se encontró un item repetido,
                if(repetido){
                    // entonces indicamos un error por pantalla.
                    formulario.muestreErrorItemRepetido();
                }
                else
                {
                    // Si todo salio bien, modificamos el stock del producto. 
                    disp.setStockActual(stockActual - cantidad);
                    
                    // Modificamos disponibilidades.
                    disponibilidades.add(disp); 
                    
                    // Cargamos disponibilidades al nuevo producto.
                    prod.setDisponibilidades(disponibilidades);
                    
                    // Construimos el item de venta:
                    item.setCantidad(cantidad);
                    item.setPrecioUnidad(disp.getPrecioVenta());
                    item.setProducto(prod);
                    
                    // Agregamos el item de venta a nuestro arreglo. 
                    itemsCargados.add(item); 
                   
                    // Finalmente, mostramos el item de venta por pantalla,
                    importeProducto = cantidad * item.getPrecioUnidad();
                    importeTotal += importeProducto; 
                    formulario.agregueItemVenta(prod.getNombre(), cantidad, item.getPrecioUnidad(), importeProducto);
                   
                    // y actualizamos el monto total:
                    formulario.establezcaMontoTotal(importeTotal);
                } 
            }
        }    
    }
    
    public void usuarioQuiereEliminarItem(int filaSeleccionada){
       // Escondemos mensajes de error antiguos. 
       formulario.escondaTodosLosCartelesDeError();
       
       // Actualizmos el importe total.
       importeTotal -= itemsCargados.get(filaSeleccionada).getPrecioUnidad() 
               * itemsCargados.get(filaSeleccionada).getCantidad();
       
       // Eliminamos el item de nuestro arreglo. 
       itemsCargados.remove(filaSeleccionada); 
       
       // Eliminamos el item de la tabla que ve el usuario,
       formulario.elimineItemVenta(filaSeleccionada);
       
       // y mostramos el monto total actualizado:
       formulario.establezcaMontoTotal(importeTotal);
    }
    
    private boolean valideDatosParaCompletarVenta(String nomCliente, String apeCliente, boolean envioGratis, 
            boolean ventaConReserva, String codArea, String numeroTelefono, float seña){
       
        boolean datosValidos = true; 
       
       if(nomCliente.isEmpty() || nomCliente.length() > 30){
           formulario.muestreErrorNombreCliente();
           datosValidos = false; 
       }
  
       if(apeCliente.isEmpty() || apeCliente.length() > 30){
           formulario.muestreErrorApellidoCliente();
           datosValidos = false;
       }

       if(itemsCargados.isEmpty()){ 
           formulario.muestreErrorPorTablaVacia();
           datosValidos = false; 
       }
       
       if(ventaConReserva){
           if(codArea.length() < 2 || codArea.length() > 4){
               formulario.muestreErrorTamañoCodArea(); 
               datosValidos = false; 
           }
           else if(!codArea.chars().allMatch( Character::isDigit )){
                formulario.muestreErrorFormatoCodArea();
                datosValidos = false;
           }
           
           if(numeroTelefono.length() < 6 || numeroTelefono.length() > 8){
               formulario.muestreErrorTamañoNumeroTelefono(); 
               datosValidos = false; 
           }
           else if(!numeroTelefono.chars().allMatch( Character::isDigit ))
            {
                formulario.muestreErrorFormatoNumeroTelefono();
                datosValidos = false;
            }
           
           if(seña <= 0){
               formulario.muestreErrorSeñaNoPositiva(); 
               datosValidos = false;
           }
           else if (seña >= importeTotal){
               formulario.muestreErrorSeñaSuperaTotal();
               datosValidos = false; 
           }
       }
       
       return datosValidos; 
    }
    
    public void usuarioQuiereCompletarVenta(String nomCliente, String apeCliente, boolean envioGratis, 
            String strMetodoPago, int idsucursal, String ubiSucursal, boolean ventaConReserva, 
            String codArea, String numeroTelefono, float seña){
       Sucursal sucursal; 
       Disponibilidad disp; 
       ArrayList<Disponibilidad> disponibilidades = new ArrayList();
       Reserva reserva = null; 
       float importeActual = -1; 
       Venta venta; 
       Venta.MetodoPago metodoPago; 
       Venta.EstadoVenta estadoVenta;
       boolean datosValidos = true;
       boolean exitoInsercionBD = true; 
       
       // Primero validamos los datos. 
       datosValidos = this.valideDatosParaCompletarVenta(nomCliente, apeCliente, envioGratis, 
               ventaConReserva, codArea, numeroTelefono, seña); 
               
       // Si todos los datos son correctos,
       if(datosValidos)
       {
            // entonces construimos la venta a dar de alta. 
            sucursal = new Sucursal(idsucursal, ubiSucursal);
            metodoPago = Venta.stringAMetodoPago(strMetodoPago);
            
            if(ventaConReserva){
                reserva = new Reserva(codArea + numeroTelefono, seña, new Date());
                estadoVenta = Venta.EstadoVenta.EN_RESERVA;
                importeActual = seña; 
            }
            else{
                estadoVenta = Venta.EstadoVenta.COMPLETADA;
                importeActual = importeTotal; 
            }
             
            venta = new Venta(-1, nomCliente, apeCliente, envioGratis, importeTotal, importeActual,  
                    new Date(), metodoPago, estadoVenta, reserva, itemsCargados, sucursal);

            // Damos de alta la venta en la base de datos:
            exitoInsercionBD = daoVenta.registrar(venta);

            if(exitoInsercionBD){
                
                // entonces modificar stock de los productos.
                for(ItemVenta item: venta.getItems()){
                    disp = item.getProducto().getDisponibilidades().get(0);
                    disponibilidades.add(disp);
                  
                }
                 daoDisp.modificaDisponibilidades(disponibilidades);
                // y damos de alta la reserva. 
                if(ventaConReserva){
                    daoReserva.registrar(reserva, venta.getId()); 
                }
                
                // reiniciamos campos de la GUI, mostramos un cartel de éxito y
                // nos preparamos para la próxima venta:
                formulario.reinicieTodosLosCampos();
                formulario.muestreCartelDeExito();
                this.prepararseParaNuevaVenta();
            }
            else{
                // Si la inserción no fue exitosa, mostramos cartel de fracaso.
                formulario.muestreCartelDeFracaso();
            }
       }
    }   
 
    private void prepararseParaNuevaVenta(){
        itemsCargados = new ArrayList();
        productosBuscados = new ArrayList();
        importeTotal = 0; 
    }
}
