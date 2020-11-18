package modelos;

import java.util.ArrayList;
import java.util.Date;

public class mdlCheque extends mdlOperacion {
    private int importePagado;
    private int tasaDeDescuento;
    private String bancoEmisor;
    private String numeroCheque;
    private Date fechaVencimiento;
    private String cuitFirmante;

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

}
