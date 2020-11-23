package Models;

import Models.Enums.*;

import java.util.Date;

public class OperacionModel {
    private TipoOperacion tipoOperacion;
    private CertificadoGarantiaModel certificadoGarantia;
    private ComisionModel comision;
    private EstadoOperacion estadoOperacion;
    private Date fecha;
    private Date fechaVencimiento;
    private int importePagado;

    public OperacionModel(){
        estadoOperacion = estadoOperacion.Ingresado;
        fecha = new Date();
    }

    public static OperacionModel CrearOperacion(TipoOperacion _tipoOperacion,
                                                CertificadoGarantiaModel _certificadoGarantia,
                                                ComisionModel _comision, Date _fechaVencimiento){

        var operacion = new OperacionModel();

        operacion.setTipoOperacion(_tipoOperacion);
        operacion.setCertificadoGarantia(_certificadoGarantia);
        operacion.setComision(_comision);
        operacion.setFechaVencimiento(_fechaVencimiento);
        return operacion;
    }

    public TipoOperacion getTipo(){
        return tipoOperacion;
    }

    public void setImportePagado(int importePagado) {
        this.importePagado = importePagado;
    }

    public int getImportePagado() {
        return importePagado;
    }

    public CertificadoGarantiaModel getCertificadoGarantia(){
        return certificadoGarantia;
    }

    public ComisionModel getComision(){
        return comision;
    }

    public EstadoOperacion getEstadoOperacion(){
        return  estadoOperacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCertificadoGarantia(CertificadoGarantiaModel certificadoGarantia) {
        this.certificadoGarantia = certificadoGarantia;
    }

    public void setComision(ComisionModel comision) {
        this.comision = comision;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
}
