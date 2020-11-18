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

    public void crearOperacion(tipoOperacion _tipoOperacion, mdlCertificadoGarantia _certificadoGarantia, mdlSocio _socio, mdlComision _comision, estadoOperacion _estadoOperacion, Date _fecha){
        tipo = _tipoOperacion.toString();
        certificadoGarantia = _certificadoGarantia;
        socio = _socio;
        comision = _comision;
        estadoOperacion = _estadoOperacion;
        fecha = _fecha;
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
