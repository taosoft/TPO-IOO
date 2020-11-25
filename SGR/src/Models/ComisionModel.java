package Models;

import Models.Enums.*;

import java.util.Date;

public class ComisionModel {
    private Date fecha;
    private EstadoComision estadoComision;

    public ComisionModel(){
        fecha = new Date();
        estadoComision = estadoComision.Calculada;
    }

    public Date getFecha(){
        return fecha;
    }

    public EstadoComision getEstadoComision() {
        return estadoComision;
    }

    public void setEstadoComision(EstadoComision estadoComision){
        this.estadoComision = estadoComision;
    }
}
