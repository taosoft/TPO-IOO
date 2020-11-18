package modelos;

import java.util.Date;

public class mdlCheque extends mdlOperacion {
    private int importePagado;
    private int tasaDeDescuento;

    private String bancoEmisor;
    private String numeroCheque;
    private Date fechaVencimiento;
    private String cuitFirmante;

    public mdlCheque(String bancoEmisor, String numeroCheque, Date fechaVencimiento, String cuitFirmante){
        this.bancoEmisor = bancoEmisor;
        this.numeroCheque = numeroCheque;
        this.fechaVencimiento = fechaVencimiento;
        this.cuitFirmante = cuitFirmante;
    }

    public mdlCheque(){}

    public void setTasaDeDescuento(int tasaDeDescuento) {
        this.tasaDeDescuento = tasaDeDescuento;
    }

    public int getTasaDeDescuento() {
        return tasaDeDescuento;
    }

    public void importeAPagar(int _importePagado) {

        importePagado = _importePagado;
    }

    public int getImportePagado() {
        return importePagado;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }
}
