package Models;

import Models.Enums.TipoOperacion;

import java.util.Date;

public class ChequeModel extends OperacionModel {
    private int tasaDeDescuento;
    private String bancoEmisor;
    private String numeroCheque;
    private String cuitFirmante;

    public static ChequeModel CrearNuevoCheque(String bancoEmisor, String numeroCheque, Date fechaVencimiento,
                                               String cuitFirmante, int importePagado){
        var cheque = new ChequeModel();

        cheque.setBancoEmisor(bancoEmisor);
        cheque.setCuitFirmante(cuitFirmante);
        cheque.setNumeroCheque(numeroCheque);
        cheque.setFechaVencimiento(fechaVencimiento);
        cheque.setImportePagado(importePagado);

        cheque.setTipoOperacion(TipoOperacion.ChequePropio);

        return cheque;
    }

    public void setTasaDeDescuento(int tasaDeDescuento) {
        this.tasaDeDescuento = tasaDeDescuento;
    }

    public int getTasaDeDescuento() {
        return tasaDeDescuento;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public String getCuitFirmante() {
        return cuitFirmante;
    }

    public void setCuitFirmante(String cuitFirmante) {
        this.cuitFirmante = cuitFirmante;
    }

    public String getBancoEmisor() {
        return bancoEmisor;
    }

    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }
}
