package Models;

public class PrestamoModel extends OperacionModel {
    private int importePagado;

    public void importeAPagar(int _importePagado){
        importePagado = _importePagado;
    }

    public int getImportePagado(){
        return importePagado;
    }
}
