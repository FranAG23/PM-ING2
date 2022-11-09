
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
    FormularioAltaVenta formulario;
    ArrayList<Producto> productosBuscados;
    DAOVenta daoVenta;
    DAOProducto daoProducto;
    DAODisponibilidad daoDisp; 
    DAOReserva daoReserva; 
    Venta venta; 
    
    public ControladorAltaVenta(FormularioAltaVenta formulario){
        this.formulario = formulario; 
        productosBuscados = new ArrayList<>(); 
        daoVenta = new DAOVenta();
        daoProducto = new DAOProducto();
        daoDisp = new DAODisponibilidad();
        daoReserva = new DAOReserva();
        venta = new Venta(); 
        venta.setSucursal(new Sucursal(1, "San Luis")); 
    }
    
    public void usuarioBuscaProducto(String nombreBuscado, int idSucursal, String ubicacionSucursal){
        int tamNombre = nombreBuscado.length();
        Disponibilidad disp; 
         
        formulario.escondaCartelesDeError();
        formulario.limpieTablaDeProductos();        
        if(tamNombre == 0 || tamNombre > 30){
            formulario.adviertaTamañoNombreProducto();
        }        
        else
        {   
            productosBuscados = daoProducto.obtengaProductosConDisponibilidad(nombreBuscado, venta.getSucursal());
            if(productosBuscados.isEmpty()){
                formulario.adviertaNoHayResultados();
            }
            else{  
                for(Producto prod: productosBuscados){  
                    disp = prod.demeDisponibilidadEnSucursal(venta.getSucursal());
                    if(disp != null)
                        formulario.agregueProductoATabla(prod, disp); 
                }
            }
        }   
    }
    
    public void usuarioQuiereAgregarItem(int filaSeleccionada, int unidadesAVender){
        Producto prodSeleccionado; 
        Disponibilidad dispProdSeleccionado; 
        ItemVenta itemAgregado;
 
        formulario.escondaCartelesDeError();
        if(unidadesAVender <= 0){ 
            formulario.adviertaCantidadNoPositiva();
        }
        else{
            prodSeleccionado = productosBuscados.get(filaSeleccionada);
            dispProdSeleccionado = prodSeleccionado.demeDisponibilidadEnSucursal(venta.getSucursal()); 
            if(dispProdSeleccionado.getStockActual() < unidadesAVender){
              formulario.adviertaUnidadesSuperaStock();
            }
            else{
                if(venta.tieneProducto(prodSeleccionado)){
                    formulario.adviertaItemRepetido();
                }
                else{ 
                    itemAgregado = venta.agregueItem(unidadesAVender, 
                                  dispProdSeleccionado.getPrecioVenta(), prodSeleccionado);
                    formulario.agregueItemVenta(itemAgregado);
                    formulario.establezcaMontoTotal(venta.getImporteTotal());
                } 
            }
        }    
    }
    
    public void usuarioQuiereEliminarItem(int filaSeleccionada){ 
       formulario.escondaCartelesDeError();
       venta.elimineItem(filaSeleccionada);
       formulario.elimineItemVenta(filaSeleccionada);
       formulario.establezcaMontoTotal(venta.getImporteTotal());
    }
    
    private boolean valideDatosParaCompletarVenta(String nomCliente, String apeCliente, boolean envioGratis, 
            boolean ventaConReserva, String codArea, String numeroTelefono, float seña){
       
       boolean datosValidos = true; 
       int tamNom = nomCliente.length();
       int tamApe = apeCliente.length();
       int tamCodArea = codArea.length();
       int tamNumTelefono = numeroTelefono.length();
       
       if(tamNom == 0 || tamNom > 30){
           formulario.muestreErrorNombreCliente();
           datosValidos = false; 
       }
       if(tamApe == 0 || tamApe > 30){
           formulario.muestreErrorApellidoCliente();
           datosValidos = false;
       }
       if(venta.noTieneItems()){ 
           formulario.adviertaItemsNoIngresados();
           datosValidos = false; 
       }     
       if(ventaConReserva){
           if(tamCodArea < 2 || tamCodArea > 4){
               formulario.adviertaTamañoCodArea(); 
               datosValidos = false; 
           }
           else if(!codArea.chars().allMatch( Character::isDigit )){
                formulario.adviertaCodAreaNoEsNumero();
                datosValidos = false;
           }
           
           if(tamNumTelefono < 6 || tamNumTelefono > 8){
               formulario.adviertaTamañoNumTelefono(); 
               datosValidos = false; 
           }
           else if(!numeroTelefono.chars().allMatch( Character::isDigit ))
            {
                formulario.advieraNumTelefonoNoEsNumero();
                datosValidos = false;
            }
           
           if(seña <= 0){
               formulario.adviertaSeñaNoPositiva(); 
               datosValidos = false;
           }
           else if (seña >= venta.getImporteTotal()){
               formulario.adviertaSeñaMuyGrande();
               datosValidos = false; 
           }
       }
       
       return datosValidos; 
    }
    
    public void usuarioQuiereCompletarVenta(String nom, String ape, boolean envGratis, String strMetodo, boolean conReserva, 
                                            String codArea, String numTel, float seña){  
       ArrayList<Disponibilidad> dispsAModificar = new ArrayList();
       Disponibilidad disp; 
       Producto prod; 
       Reserva reserva = new Reserva(); 
       Venta.EstadoVenta estadoVenta;
       boolean datosValidos = true;
       boolean exitoInsercionBD = true; 
       
       datosValidos = this.valideDatosParaCompletarVenta(nom, ape, envGratis, 
                                                        conReserva, codArea, numTel, seña); 
       if(datosValidos)
       {
            venta.setNombreCliente(nom);
            venta.setApellidoCliente(ape);
            venta.setEnvioGratis(envGratis);
            venta.setMetodoPago(Venta.stringAMetodoPago(strMetodo));
            if(conReserva){
                reserva = new Reserva("(" + codArea + ")" + numTel, seña, new Date());
                estadoVenta = Venta.EstadoVenta.EN_RESERVA;
                venta.setImporteActual(seña);
                venta.setReserva(reserva); 
            }
            else{
                estadoVenta = Venta.EstadoVenta.COMPLETADA;
                venta.setImporteActual(venta.getImporteTotal());
            }
            venta.setEstado(estadoVenta);
            for(ItemVenta item: venta.getItems()){
                prod = item.getProducto();
                disp = prod.demeDisponibilidadEnSucursal(venta.getSucursal()); 
                disp.disminuyaStock(item.getCantidad()); 
                dispsAModificar.add(disp); 
            }
            
            exitoInsercionBD = daoVenta.registrar(venta);
            if(exitoInsercionBD){
                 daoDisp.modificarDisponibilidades(dispsAModificar);
                if(conReserva){
                    daoReserva.registrar(reserva, venta.getId()); 
                }
                formulario.reinicieTodosLosCampos();
                formulario.muestreCartelDeExito();
                productosBuscados = new ArrayList();
                venta = new Venta();
                venta.setSucursal(new Sucursal(1, "San Luis")); 
            }
            else{
                formulario.muestreCartelDeFracaso();
            }
       }
    }   
    
}
