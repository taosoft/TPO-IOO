package Models;

import Models.Enums.*;

import java.util.Date;

public class PrestamoModel extends OperacionModel {
    private String banco;
    private float tasa;
    private int cantidadCuotas;
    private TipoSistema tipoSistema;
    private Date fechaAcreditacion;

    public static PrestamoModel CrearNuevoPrestamo(String banco, float tasa, int cantidadCuotas,
                                                   TipoSistema tipoSistema, int importe, Date fechaAcreditacion){
        var prestamo = new PrestamoModel();

        prestamo.setBanco(banco);
        prestamo.setTasa(tasa);
        prestamo.setCantidadCuotas(cantidadCuotas);
        prestamo.setFechaAcreditacion(fechaAcreditacion);
        prestamo.setImportePagado(importe);

        prestamo.setTipoOperacion(TipoOperacion.Prestamo);

        return prestamo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public TipoSistema getTipoSistema() {
        return tipoSistema;
    }

    public void setTipoSistema(TipoSistema tipoSistema) {
        this.tipoSistema = tipoSistema;
    }

    public Date getFechaAcreditacion() {
        return fechaAcreditacion;
    }

    public void setFechaAcreditacion(Date fechaAcreditacion) {
        this.fechaAcreditacion = fechaAcreditacion;
    }
}
