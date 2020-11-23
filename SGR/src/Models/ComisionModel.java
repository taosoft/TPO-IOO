package Models;

import Models.Enums.EstadoComision;

import java.util.Date;

public class ComisionModel {
    private String tipo;
    private Date fechaCambio;
    private EstadoComision estadoComision;
    private String tipoCambioRealizado;
    private String nombreResponsable;

    public ComisionModel(){
        fechaCambio = new Date();
        estadoComision = estadoComision.Calculada;
    }

    public static ComisionModel crearComision(String _tipo, Date _fechaCambio, EstadoComision _estadoComision, String _tipoCambioRealizado, String _nombreResponsable){

        var comision = new ComisionModel();

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
