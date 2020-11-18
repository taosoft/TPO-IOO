package modelos;

import java.util.ArrayList;
import java.util.Date;

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
    private ArrayList<mdlLineaCredito> lineaCreditos;


    public void obtenerSocio(String _cuit){
        cuit = _cuit;
    }

    public void CrearSocio(String _nombreUsuario, String _cuit, String _razonSocial, String _tipoEmpresa, String _actividadPrincipal, String _direccion,
                           String _telefono, String _email, Date _fechaRecepcion, Date _fechaInicioActividades, estadoSocio _estado, tipoSocio _tipoSocio,
                           ArrayList<mdlLogEstadoSocio> _logs, tipoDocumento _tipoDocumento, ArrayList<mdlAporte> _aportes){

        nombreUsuario = _nombreUsuario;
        cuit = _cuit;
        razonSocial = _razonSocial;
        tipoEmpresa = _tipoEmpresa;
        actividadPrincipal = _actividadPrincipal;
        direccion = _direccion;
        telefono = _telefono;
        email = _email;
        fechaRecepcion = _fechaRecepcion;
        fechaInicioActividades = _fechaInicioActividades;
        estado = _estado;
        tipoSocio = _tipoSocio;
        logs = _logs;
        tipoDocumento = _tipoDocumento;
        aportes = _aportes;
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

    public ArrayList<mdlLineaCredito> getLineaCreditos(){
        return lineaCreditos;
    }
}
