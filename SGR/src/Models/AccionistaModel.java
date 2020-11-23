package Models;

public class AccionistaModel {
    private String cuit;
    private String razonSocial;
    private float porcentajeParticipacion;

    public static AccionistaModel CrearNuevoAccionista(String cuit, String razonSocial, float porcentajeParticipacion){
        var accionista = new AccionistaModel();
        accionista.setCuit(cuit);
        accionista.setRazonSocial(razonSocial);
        accionista.setPorcentajeParticipacion(porcentajeParticipacion);
        return accionista;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public float getPorcentajeParticipacion() {
        return porcentajeParticipacion;
    }

    public void setPorcentajeParticipacion(float porcentajeParticipacion) {
        this.porcentajeParticipacion = porcentajeParticipacion;
    }
}
