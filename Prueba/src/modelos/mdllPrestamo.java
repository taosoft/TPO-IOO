package modelos;

public class mdllPrestamo extends mdlOperacion{
    private int importePagado;

    public void importeAPagar(int _importePagado){
        importePagado = _importePagado;
    }

    public int getImportePagado(){
        return importePagado;
    }
}
