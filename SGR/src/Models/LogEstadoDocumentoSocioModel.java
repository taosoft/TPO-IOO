package Models;

import Models.Enums.*;

import java.util.Date;

public class LogEstadoDocumentoSocioModel {
    private Date fecha;
    private EstadoDocumento estadoAnterior;
    private EstadoDocumento estadoNuevo;
    private String nombreUsuario;

    public static LogEstadoDocumentoSocioModel CrearLogEstadoDocumentoSocioModel(Date fecha,
                                                                                 EstadoDocumento estadoAnterior,
                                                                     EstadoDocumento estadoNuevo,
                                                                                 String nombreUsuario) {
        var logEstadoDocumentoSocioModel = new LogEstadoDocumentoSocioModel();
        logEstadoDocumentoSocioModel.setFecha(fecha);
        logEstadoDocumentoSocioModel.setEstadoAnterior(estadoAnterior);
        logEstadoDocumentoSocioModel.setEstadoNuevo(estadoNuevo);
        logEstadoDocumentoSocioModel.setNombreUsuario(nombreUsuario);
        return logEstadoDocumentoSocioModel;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public EstadoDocumento getEstadoNuevo() {
        return estadoNuevo;
    }

    public void setEstadoNuevo(EstadoDocumento estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }

    public EstadoDocumento getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(EstadoDocumento estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }
}
