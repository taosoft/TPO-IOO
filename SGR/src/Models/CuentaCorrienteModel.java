package Models;

import Models.Enums.*;

import java.util.Date;

public class CuentaCorrienteModel extends OperacionModel {
    private int importePagado;
    private String empresa;

    public static CuentaCorrienteModel CrearNuevaCuentaCorriente(String empresa, Date fechaVencimiento,
                                                                 int importePagado){
        var cuentaCorriente = new CuentaCorrienteModel();

        cuentaCorriente.setEmpresa(empresa);
        cuentaCorriente.setFechaVencimiento(fechaVencimiento);
        cuentaCorriente.setImportePagado(importePagado);

        cuentaCorriente.setTipoOperacion(TipoOperacion.CCComercial);

        return cuentaCorriente;
    }

    public void setImportePagado(int importePagado){
        this.importePagado = importePagado;
    }

    public int getImportePagado(){
        return importePagado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
