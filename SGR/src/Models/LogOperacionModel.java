package Models;

import Models.Enums.*;

import java.util.Date;

public class LogOperacionModel {
    private Date fecha;
    private EstadoOperacion estadoAnterior;
    private EstadoOperacion estadoNuevo;
    private int idOperacion;
    private String nombreUsuario;

    public LogOperacionModel(EstadoOperacion estadoAnterior, EstadoOperacion estadoNuevo, int idOperacion,
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

    public EstadoOperacion getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(EstadoOperacion estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public EstadoOperacion getEstadoNuevo() {
        return estadoNuevo;
    }

    public void setEstadoNuevo(EstadoOperacion estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }
}
