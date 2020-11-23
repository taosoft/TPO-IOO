package ViewModels;

public class ComisionCalculadaViewModel {
    private float porcentajeComision;
    private String numeroCheque;
    private int importePagado;

    public ComisionCalculadaViewModel(float porcentajeComision, String numeroCheque, int importePagado){
        this.importePagado = importePagado;
        this.numeroCheque = numeroCheque;
        this.porcentajeComision = porcentajeComision;
    }

    public float totalComision() {
        return (float)importePagado*(porcentajeComision/100);
    }

    public float getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public int getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(int importePagado) {
        this.importePagado = importePagado;
    }
}
