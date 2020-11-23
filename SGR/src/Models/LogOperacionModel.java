package Models;

import Models.Enums.EstadoOperacion;
import Models.Enums.TipoOperacion;

import java.util.Date;

public class LogOperacionModel {
    private Date fecha;
    private EstadoOperacion estadoAnterior;
    private EstadoOperacion estadoNuevo;
    private TipoOperacion tipoOperacion;
    private String nombreUsuario;

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

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
