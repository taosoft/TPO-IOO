package Models;

import Models.Enums.*;

import java.util.Date;

public class ComisionModel {
    private String tipo;
    private Date fecha;
    private EstadoComision estadoComision;
    private String tipoCambioRealizado;
    private String nombreResponsable;

    public ComisionModel(){
        fecha = new Date();
        estadoComision = estadoComision.Calculada;
    }

    public static ComisionModel CrearComision(String _tipo, Date _fechaCambio, EstadoComision _estadoComision,
                                              String _tipoCambioRealizado, String _nombreResponsable) {

        var comision = new ComisionModel();

        comision.tipo = _tipo;
        comision.fecha = _fechaCambio;
        comision.estadoComision = _estadoComision;
        comision.tipoCambioRealizado = _tipoCambioRealizado;
        comision.nombreResponsable = _nombreResponsable;

        return comision;
    }

    public String getTipo(){
        return  tipo;
    }

    public Date getFecha(){
        return fecha;
    }

    public EstadoComision getEstadoComision() {
        return estadoComision;
    }

    public String getTipoCambioRealizado() {
        return tipoCambioRealizado;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }
}
