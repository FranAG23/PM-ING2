
package clasesEntidad;

import java.util.Date;

public class Egreso {
    
    // Atributos
    
    private int id;
    private float montoTotal;
    private Date fecha;
    private Sucursal sucursal;
  
    // Constructor

    public Egreso(int id, float montoTotal, Date fecha, Sucursal sucursal) {
        
        this.id = id;
        this.montoTotal = montoTotal;
        this.fecha = fecha;
        this.sucursal = sucursal;
    }
    
    // Getters y Setters

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public float getMontoTotal() {return montoTotal;}
    public void setMontoTotal(float montoTotal) {this.montoTotal = montoTotal;}

    public Date getFecha() {return fecha;}
    public void setFecha(Date fecha) {this.fecha = fecha;}

    public Sucursal getSucursal() {return sucursal;}
    public void setSucursal(Sucursal sucursal) {this.sucursal = sucursal;}
    
}
