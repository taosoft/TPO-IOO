package Models;

import Models.Enums.TipoOperacion;
import Models.Enums.EstadoOperacion;

import java.util.Date;

public class mdlOperacion {
    private String tipo;
    private mdlCertificadoGarantia certificadoGarantia;
    private SocioModel socio;
    private mdlComision comision;
    private EstadoOperacion estadoOperacion;
    private Date fecha;

    public mdlOperacion(){
        estadoOperacion = estadoOperacion.Ingresado;
        fecha = new Date();
    }

    public static mdlOperacion crearOperacion(TipoOperacion _tipoOperacion, mdlCertificadoGarantia _certificadoGarantia, SocioModel _socio, mdlComision _comision, EstadoOperacion _estadoOperacion, Date _fecha){

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

    public SocioModel getSocio(){
        return socio;
    }

    public mdlComision getComision(){
        return comision;
    }

    public EstadoOperacion getEstadoOperacion(){
        return  estadoOperacion;
    }

    public Date getFecha() {
        return fecha;
    }
}
