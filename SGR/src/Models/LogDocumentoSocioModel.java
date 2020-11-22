package Models;

import Models.Enums.*;

import java.util.Date;

public class LogDocumentoSocioModel {
    private Date fecha;
    private TipoDocumento tipoAnterior;
    private TipoDocumento tipoNuevo;
    private String nombreUsuario;

    public static LogDocumentoSocioModel CrearLogDocumentoSocioModel(Date fecha, TipoDocumento tipoAnterior,
                                                                     TipoDocumento tipoNuevo, String nombreUsuario) {
        var logDocumentoSocioModel = new LogDocumentoSocioModel();
        logDocumentoSocioModel.setFecha(fecha);
        logDocumentoSocioModel.setTipoAnterior(tipoAnterior);
        logDocumentoSocioModel.setTipoNuevo(tipoNuevo);
        logDocumentoSocioModel.setNombreUsuario(nombreUsuario);
        return logDocumentoSocioModel;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoDocumento getTipoAnterior() {
        return tipoAnterior;
    }

    public void setTipoAnterior(TipoDocumento tipoAnterior) {
        this.tipoAnterior = tipoAnterior;
    }

    public TipoDocumento getTipoNuevo() {
        return tipoNuevo;
    }

    public void setTipoNuevo(TipoDocumento tipoNuevo) {
        this.tipoNuevo = tipoNuevo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}

