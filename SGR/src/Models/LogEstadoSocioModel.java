package Models;

import Models.Enums.*;

import java.util.Date;

public class LogEstadoSocioModel {
    private Date fecha;
    private EstadoSocio estadoAnterior;
    private EstadoSocio estadoNuevo;
    private String nombreUsuario;

    public static LogEstadoSocioModel CrearNuevoLogEstadoSocioModel(Date fecha, EstadoSocio estadoAnterior,
                                                                    EstadoSocio estadoNuevo, String nombreUsuario){
        var logEstadoSocioModel = new LogEstadoSocioModel();
        logEstadoSocioModel.setFecha(fecha);
        logEstadoSocioModel.setEstadoAnterior(estadoAnterior);
        logEstadoSocioModel.setEstadoNuevo(estadoNuevo);
        logEstadoSocioModel.setNombreUsuario(nombreUsuario);

        return logEstadoSocioModel;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EstadoSocio getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(EstadoSocio estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public EstadoSocio getEstadoNuevo() {
        return estadoNuevo;
    }

    public void setEstadoNuevo(EstadoSocio estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
