package clases_control;

import clases_entidad.ItemVenta;
import clases_entidad.Producto;
import clases_entidad.Sucursal;
import clases_entidad.Venta;
import clases_entidad.Venta.EstadoVenta;
import clases_entidad.Venta.MetodoPago;
import clases_entidad.auxiliares.RenglonTablaAltaVenta;
import com.raven.form.FormularioAltaVenta;
import dao.DAOVenta;
import java.util.ArrayList;
import java.util.Date;

public class ManagerVenta 
{
    DAOVenta daoVenta;
    FormularioAltaVenta formulario;
    
    public ManagerVenta(FormularioAltaVenta formulario) {
        this.formulario = formulario;
    }
     

    /*
        Descripción: Recibe los datos que le trasmite la interfaz y los valida para luego construir un objeto
        de tipo Venta. En caso de que los datos no sean correctos, invoca a la interfaz para que se 
        desplieguen mensajes de error. En caso de que los datos sean correctos, invoca a daoVenta para que 
        inserte el objeto en la base de datos. 
    
        Precondiciones: listaRenglones no es null. 
    */
    public void altaVenta(String nombreCliente, String apellidoCliente, boolean envioGratis, float importe,
                          String strMetodoPago, String ubiSucursal, ArrayList<RenglonTablaAltaVenta> listaRenglones)
    {        
       daoVenta = new DAOVenta();
       boolean datosValidadosCorrectamente = true;
       boolean exitoInsercionBD;

       Producto producto; 
       ItemVenta item;
       Sucursal sucursal; 
       Venta venta; 
       ArrayList<ItemVenta> itemsVenta = new ArrayList<>();
       MetodoPago metodoPago; 
       EstadoVenta estadoVenta;
      
       // Validacion de datos:
       if(nombreCliente.isEmpty()|| nombreCliente.length() > 20){
           formulario.mostrarErrorNombre();
           datosValidadosCorrectamente = false; 
       }
       if(apellidoCliente.isEmpty() || apellidoCliente.length() > 20){
           formulario.mostrarErrorApellido();
           datosValidadosCorrectamente = false;
       }
       if(listaRenglones.isEmpty()){
           formulario.mostrarErrorTablaVacia();
           datosValidadosCorrectamente = false; 
       }
       
       if(datosValidadosCorrectamente)
       {
            // Construcción del objeto sucursal: 
            sucursal = new Sucursal(ubiSucursal);

            // Construcción de los objetos item, producto y itemsVenta: 
            for(RenglonTablaAltaVenta renglon: listaRenglones){
                // Construcción del objeto producto:
                producto = new Producto(renglon.getIDProducto(), renglon.getNombreProducto(), "Indefinido", 
                                        Producto.CategoriaProducto.ACCESORIO);

                // Construcción del objeto item:
                item = new ItemVenta(renglon.getCantidad(), renglon.getPrecioPorUnidad(), producto);

                // Agregamos un nuevo item de venta a nuestra lista: 
                itemsVenta.add(item);
            }

            // Construcción del objeto venta:
            // Conversión de string a enumerado MetodoPago: 
            metodoPago = MetodoPago.valueOf(strMetodoPago);
            // Hasta que no agreguemos el CU "Alta Reserva", nuestras ventas estarán siempre completas:
            estadoVenta = EstadoVenta.COMPLETADA;
            venta = new Venta(nombreCliente, apellidoCliente, envioGratis, importe,  new Date(),
                              metodoPago, estadoVenta, sucursal, itemsVenta);

            // Dar de alta venta en Base de datos:
            exitoInsercionBD = daoVenta.registrar(venta);

            // Si la insercion en la BD fue exitosa,
            if(exitoInsercionBD){
                // reiniciar campos de la GUI. 
                formulario.reiniciarCampos();
                // entonces mostrar un cartel de éxito.
                formulario.mostrarCartelExito();
            }
            else{
                // Si no, mostrar cartel de fracaso.
                formulario.mostrarCartelFracaso();
            }
       }
    }
}
