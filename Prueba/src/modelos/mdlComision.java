package modelos;

import java.util.Date;

public class mdlComision {
    private String tipo;
    private Date fechaCambio;
    private estadoComision estadoComision;
    private String tipoCambioRealizado;
    private String nombreResponsable;

    public mdlComision(){
        fechaCambio = new Date();
        estadoComision = modelos.estadoComision.Calculada;
    }

    public void crearComision(String _tipo, Date _fechaCambio,estadoComision _estadoComision, String _tipoCambioRealizado, String _nombreResponsable){

        var comision = new mdlComision();

        comision.tipo = _tipo;
        comision.fechaCambio = _fechaCambio;
        comision.estadoComision = _estadoComision;
        comision.tipoCambioRealizado = _tipoCambioRealizado;
        comision.nombreResponsable = _nombreResponsable;
    }

    public String getTipo(){
        return  tipo;
    }

    public Date getFechaCambio(){
        return fechaCambio;
    }

    public modelos.estadoComision getEstadoComision() {
        return estadoComision;
    }

    public String getTipoCambioRealizado() {
        return tipoCambioRealizado;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }
}
