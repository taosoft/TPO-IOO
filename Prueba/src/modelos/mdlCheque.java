package modelos;

import java.util.Date;

public class mdlCheque extends mdlOperacion{
    private String bancoEmisor;
    private String numeroCheque;
    private Date fechaVencimiento;
    private String cuitFirmante;

    private int importePagado;

    public void importeAPagar(int _importePagado){
        importePagado = _importePagado;
    }

    public int getImportePagado(){
        return importePagado;
    }
}
