
package dataTransferObject;

import java.util.Date;

public class VentaDTO {
    
    private String nombreCliente;
    private float importeTotal;
    private Date fecha;

    public VentaDTO(String nombreCliente, String apellidoCliente, float importeTotal, Date fecha) {
        
        this.nombreCliente = nombreCliente + apellidoCliente;
        this.importeTotal = importeTotal;
        this.fecha = fecha;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(float importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
