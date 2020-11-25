package Models.ViewModels;

public class ComisionCalculadaViewModel {
    private double porcentajeComision;
    private String numeroCheque;
    private int importePagado;

    public ComisionCalculadaViewModel(double porcentajeComision, String numeroCheque, int importePagado){
        this.importePagado = importePagado;
        this.numeroCheque = numeroCheque;
        this.porcentajeComision = porcentajeComision;
    }

    public double totalComision() {
        return (double)importePagado*(porcentajeComision/100);
    }

    public double getPorcentajeComision() {
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
