package modelos;

public class mdlCuentaCorriente extends mdlOperacion {
    private int importePagado;

    public void importeAPagar(int _importePagado){
        importePagado = _importePagado;
    }

    public int getImportePagado(){
        return importePagado;
    }
}
