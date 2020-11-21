package modelos;

import java.util.Date;

public class mdlPrestamo{
    private int importePagado;
    private String banco;
    private int importeTotal;
    private int tasa;
    private Date fechaAcreditacion;
    private int cantidadDeCuotas;
    private tipoSistema tipoSistema;

    public mdlPrestamo(){

    }

    public static mdlPrestamo CrearPrestamo(String _nombreUsuario, String _banco, int _importeTotal, int _tasa, Date _fechaAcreditacion,
                                            int _cantidadDeCuotas, tipoSistema _tipoSistema)



    public void importeAPagar(int _importePagado){
        importePagado = _importePagado;
    }

    // Gets

    public int getImportePagado(){
        return importePagado;
    }

    public String getBanco() {
        return banco;
    }

    public int getImporteTotal() {
        return importeTotal;
    }

    public int getTasa() {
        return tasa;
    }

    public Date getFechaAcreditacion() {
        return fechaAcreditacion;
    }

    public int getCantidadDeCuotas() {
        return cantidadDeCuotas;
    }

    public modelos.tipoSistema getTipoSistema() {
        return tipoSistema;
    }

    // Sets

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public void setImporteTotal(int importeTotal) {
        this.importeTotal = importeTotal;
    }

    public void setTasa(int tasa) {
        this.tasa = tasa;
    }

    public void setFechaAcreditacion(Date fechaAcreditacion) {
        this.fechaAcreditacion = fechaAcreditacion;
    }

    public void setCantidadDeCuotas(int cantidadDeCuotas) {
        this.cantidadDeCuotas = cantidadDeCuotas;
    }

    public void setTipoSistema(modelos.tipoSistema tipoSistema) {
        this.tipoSistema = tipoSistema;
    }

}
