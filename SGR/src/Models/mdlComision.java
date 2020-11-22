package Models;

import Models.Enums.EstadoComision;

import java.util.Date;

public class mdlComision {
    private String tipo;
    private Date fechaCambio;
    private EstadoComision estadoComision;
    private String tipoCambioRealizado;
    private String nombreResponsable;

    public mdlComision(){
        fechaCambio = new Date();
        estadoComision = estadoComision.Calculada;
    }

    public static mdlComision crearComision(String _tipo, Date _fechaCambio, EstadoComision _estadoComision, String _tipoCambioRealizado, String _nombreResponsable){

        var comision = new mdlComision();

        comision.tipo = _tipo;
        comision.fechaCambio = _fechaCambio;
        comision.estadoComision = _estadoComision;
        comision.tipoCambioRealizado = _tipoCambioRealizado;
        comision.nombreResponsable = _nombreResponsable;

        return comision;
    }

    public String getTipo(){
        return  tipo;
    }

    public Date getFechaCambio(){
        return fechaCambio;
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
