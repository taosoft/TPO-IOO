package modelos;

import java.util.Date;

public class mdlOperacion {
    private String tipo;
    private mdlCertificadoGarantia certificadoGarantia;
    private mdlSocio socio;
    private mdlComision comision;
    private estadoOperacion estadoOperacion;
    private Date fecha;

    public mdlOperacion(){
        estadoOperacion = modelos.estadoOperacion.Ingresado;
        fecha = new Date();
    }

    public static mdlOperacion crearOperacion(tipoOperacion _tipoOperacion, mdlCertificadoGarantia _certificadoGarantia, mdlSocio _socio, mdlComision _comision, estadoOperacion _estadoOperacion, Date _fecha){

        var operacion = new mdlOperacion();

        operacion.tipo = _tipoOperacion.toString();
        operacion.certificadoGarantia = _certificadoGarantia;
        operacion.socio = _socio;
        operacion.comision = _comision;
        return operacion;
    }

    public String getTipo(){
        return tipo;
    }

    public mdlCertificadoGarantia getCertificadoGarantia(){
        return  certificadoGarantia;
    }

    public mdlSocio getSocio(){
        return socio;
    }

    public mdlComision getComision(){
        return comision;
    }

    public estadoOperacion getEstadoOperacion(){
        return  estadoOperacion;
    }

    public Date getFecha() {
        return fecha;
    }

}
