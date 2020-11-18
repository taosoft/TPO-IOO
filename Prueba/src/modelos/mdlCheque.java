package modelos;

public class mdlCheque extends mdlOperacion{
    private int importePagado;
    private int tasaDeDescuento;
    public void setTasaDeDescuento(int tasaDeDescuento){
        this.tasaDeDescuento = tasaDeDescuento;
    }
    public int getTasaDeDescuento(){
        return tasaDeDescuento;
    }

    public void importeAPagar(int _importePagado){
        importePagado = _importePagado;
    }

    public int getImportePagado(){
        return importePagado;
    }
}
