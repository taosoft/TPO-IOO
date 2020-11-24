package Models;

import Models.Enums.*;

import java.util.Date;

public class LogComisionModel {
    private Date fecha;
    private EstadoComision estadoAnterior;
    private EstadoComision estadoNuevo;
    private int idOperacion;
    private String nombreUsuario;

    public LogComisionModel(EstadoComision estadoAnterior, EstadoComision estadoNuevo, int idOperacion,
                             String nombreUsuario){
        fecha = new Date();
        this.estadoAnterior = estadoAnterior;
        this.estadoNuevo = estadoNuevo;
        this.idOperacion = idOperacion;
        this.nombreUsuario = nombreUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EstadoComision getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(EstadoComision estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public EstadoComision getEstadoNuevo() {
        return estadoNuevo;
    }

    public void setEstadoNuevo(EstadoComision estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
