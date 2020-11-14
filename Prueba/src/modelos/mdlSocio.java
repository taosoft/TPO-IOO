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


    public void obtenerSocio(String _cuit){
        cuit = _cuit;
    }

    public String getCuit(){
        return cuit;
    }
}
