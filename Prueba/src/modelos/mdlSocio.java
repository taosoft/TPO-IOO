package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class mdlSocio {

    private String nombreUsuario;
    private String cuit;
    private String razonSocial;
    private String tipoEmpresa;
    private String actividadPrincipal;
    private String direccion;
    private String telefono;
    private String email;
    private Date fechaRecepcion;
    private Date fechaInicioActividades;
    private estadoSocio estado;
    private tipoSocio tipoSocio;
    private ArrayList<mdlLogEstadoSocio> logs;
    private tipoDocumento tipoDocumento;
    private ArrayList<mdlAporte> aportes;

    public mdlSocio(){
        aportes = new ArrayList<>();
        logs = new ArrayList<>();
        estado = estadoSocio.Postulante;
    }

    public static mdlSocio CrearSocio(String _nombreUsuario, String _cuit, String _razonSocial, String _tipoEmpresa,
                                      String _actividadPrincipal, String _direccion, String _telefono, String _email,
                                      Date _fechaRecepcion, Date _fechaInicioActividades, tipoSocio _tipoSocio,
                                      tipoDocumento _tipoDocumento){
        var nuevoSocio = new mdlSocio();

        nuevoSocio.setNombreUsuario(_nombreUsuario);
        nuevoSocio.setCuit(_cuit);
        nuevoSocio.setRazonSocial(_razonSocial);
        nuevoSocio.setTipoEmpresa(_tipoEmpresa);
        nuevoSocio.setActividadPrincipal(_actividadPrincipal);
        nuevoSocio.setDireccion(_direccion);
        nuevoSocio.setTelefono(_telefono);
        nuevoSocio.setEmail(_email);
        nuevoSocio.setFechaRecepcion(_fechaRecepcion);
        nuevoSocio.setFechaInicioActividades(_fechaInicioActividades);
        nuevoSocio.setTipoSocio(_tipoSocio);
        nuevoSocio.setTipoDocumento(_tipoDocumento);

        return nuevoSocio;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public String getRazonSocial(){
        return razonSocial;
    }

    public String getTipoEmpresa(){
        return tipoEmpresa;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getEmail(){
        return email;
    }

    public Date getFechaRecepcion(){
        return fechaRecepcion;
    }

    public Date getFechaInicioActividades(){
        return fechaInicioActividades;
    }

    public estadoSocio getEstadoSocio(){
        return estado;
    }

    public tipoSocio getTipoSocio(){
        return tipoSocio;
    }

    public ArrayList<mdlLogEstadoSocio> getLogEstadoSocio(){
        return logs;
    }

    public tipoDocumento getTipoDocumento(){
        return tipoDocumento;
    }

    public ArrayList<mdlAporte> getAportes(){
        return aportes;
    }

    public String getCuit(){
        return cuit;
    }

    public void setNombreUsuario(String nombre){
        nombreUsuario = nombre;
    }

    public void setRazonSocial(String razonSocial){
        this.razonSocial = razonSocial;
    }

    public void setTipoEmpresa(String tipoEmpresa){
        this.tipoEmpresa = tipoEmpresa;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setFechaRecepcion(Date fechaRecepcion){
        this.fechaRecepcion = fechaRecepcion;
    }

    public void setFechaInicioActividades(Date fechaInicioActividades){
        this.fechaInicioActividades = fechaInicioActividades;
    }

    public void setEstadoSocio(estadoSocio estado){
        this.estado = estado;
    }

    public void setTipoSocio(tipoSocio tipoSocio){
        this.tipoSocio = tipoSocio;
    }

    public void setTipoDocumento(tipoDocumento tipoDocumento){
        this.tipoDocumento = tipoDocumento;
    }

    public void setCuit(String cuit){
        this.cuit = cuit;
    }

    public void setActividadPrincipal(String actividadPrincipal){
        this.actividadPrincipal = actividadPrincipal;
    }
}
