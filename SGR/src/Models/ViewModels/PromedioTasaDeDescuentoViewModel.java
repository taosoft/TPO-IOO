package Models.ViewModels;

public class PromedioTasaDeDescuentoViewModel {
    private String nombreSocio;
    private float tasaDescuentoCheques;
    private float tasaDescuentoPagares;
    private double totalOperadoCheques;
    private double totalOperadoPagares;
    private int cantidad;

    public PromedioTasaDeDescuentoViewModel(String nombreSocio, double totalOperadoCheques,
                                            double totalOperadoPagares, float tasaDescuentoCheques, float tasaDescuentoPagares) {
        this.nombreSocio = nombreSocio;
        this.totalOperadoCheques = totalOperadoCheques;
        this.totalOperadoPagares = totalOperadoPagares;
        this.tasaDescuentoCheques = tasaDescuentoCheques;
        this.tasaDescuentoPagares = tasaDescuentoPagares;
    }
    public PromedioTasaDeDescuentoViewModel(){

    }

    public float getPromedioCheques(){
        return tasaDescuentoCheques/cantidad;
    }
    public float getPromedioPagares(){
        return tasaDescuentoPagares/cantidad;
    }

    public void setTasaDescuentoCheques(float tasaDescuentoCheques) {
        this.tasaDescuentoCheques = tasaDescuentoCheques;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public void setTasaDescuentoPagares(float tasaDescuentoPagares) {
        this.tasaDescuentoPagares = tasaDescuentoPagares;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalOperadoCheques() {
        return totalOperadoCheques;
    }

    public void setTotalOperadoCheques(double totalOperadoCheques) {
        this.totalOperadoCheques = totalOperadoCheques;
    }

    public double getTotalOperadoPagares() {
        return totalOperadoPagares;
    }

    public void setTotalOperadoPagares(double totalOperadoPagares) {
        this.totalOperadoPagares = totalOperadoPagares;
    }
}
