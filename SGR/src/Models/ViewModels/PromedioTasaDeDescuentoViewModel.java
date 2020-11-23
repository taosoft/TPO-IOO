package Models.ViewModels;

public class PromedioTasaDeDescuentoViewModel {
    private String nombreSocio;
    private float tasaDescuento;
    private String totalOperado;
    private int Cantidad;

    public PromedioTasaDeDescuentoViewModel(String nombreSocio, String totalOperado, float tasaDescuento) {
        this.nombreSocio = nombreSocio;
        this.totalOperado = totalOperado;
        this.tasaDescuento = tasaDescuento;

    }
    public PromedioTasaDeDescuentoViewModel(){

    }

    public float getPromedio(){
        return tasaDescuento/Cantidad;
    }
    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public void setTotalOperado(String totalOperado) {
        this.totalOperado = totalOperado;
    }

    public void setTasaDescuento(float tasaDescuento) {
        this.tasaDescuento = tasaDescuento;
    }

    public String getTotalOperado() {
        return totalOperado;
    }

    public float getTasaDescuento() {
        return tasaDescuento;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public int getCantidad() {
        return Cantidad;
    }
}
