package Models;

import Models.Enums.*;
import Views.AporteView;

import java.util.ArrayList;
import java.util.Date;

public class SocioModel {

    private String nombreUsuario;
    private String cuit;
    private String razonSocial;
    private TipoEmpresa tipoEmpresa;
    private String actividadPrincipal;
    private String direccion;
    private String telefono;
    private String email;
    private Date fechaRecepcion;
    private Date fechaInicioActividades;
    private EstadoSocio estado;
    private TipoSocio tipoSocio;
    private ArrayList<LogEstadoSocioModel> logs;
    private TipoDocumento tipoDocumento;
    private EstadoDocumento estadoDocumento;
    private ArrayList<AporteModel> aportes;
    private ArrayList<LineaCreditoModel> lineaCreditos;
    private ArrayList<AccionistaModel> accionistas;

    public SocioModel(){
        aportes = new ArrayList<>();
        logs = new ArrayList<>();
        estado = EstadoSocio.Postulante;
        lineaCreditos = new ArrayList<>();
    }

    public static SocioModel CrearSocio(String _nombreUsuario, String _cuit, String _razonSocial, TipoEmpresa _tipoEmpresa,
                                        String _actividadPrincipal, String _direccion, String _telefono, String _email,
                                        Date _fechaInicioActividades, TipoSocio _tipoSocio){
        var nuevoSocio = new SocioModel();

        nuevoSocio.setNombreUsuario(_nombreUsuario);
        nuevoSocio.setCuit(_cuit);
        nuevoSocio.setRazonSocial(_razonSocial);
        nuevoSocio.setTipoEmpresa(_tipoEmpresa);
        nuevoSocio.setActividadPrincipal(_actividadPrincipal);
        nuevoSocio.setDireccion(_direccion);
        nuevoSocio.setTelefono(_telefono);
        nuevoSocio.setEmail(_email);

        nuevoSocio.setFechaInicioActividades(_fechaInicioActividades);
        nuevoSocio.setTipoSocio(_tipoSocio);

        var listaTipoOperaciones = new ArrayList<TipoOperacion>();
        listaTipoOperaciones.add(TipoOperacion.CCComercial);
        listaTipoOperaciones.add(TipoOperacion.Prestamo);
        listaTipoOperaciones.add(TipoOperacion.ChequePropio);
        listaTipoOperaciones.add(TipoOperacion.ChequeTerceros);

        var lineaCredito = LineaCreditoModel.crearLineaCredito(new Date(),
                112,
                listaTipoOperaciones, 1);
        nuevoSocio.addLineaCredito(lineaCredito);
        return nuevoSocio;
    }

    // Gets
    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public String getRazonSocial(){
        return razonSocial;
    }

    public TipoEmpresa getTipoEmpresa(){
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

    public EstadoSocio getEstadoSocio(){
        return estado;
    }

    public TipoSocio getTipoSocio(){
        return tipoSocio;
    }

    public ArrayList<LogEstadoSocioModel> getLogEstadoSocio(){
        return logs;
    }

    public TipoDocumento getTipoDocumento(){
        return tipoDocumento;
    }

    public ArrayList<AporteModel> getAportes(){
        return aportes;
    }

    public String getCuit(){
        return cuit;
    }


    public ArrayList<LineaCreditoModel> getLineaCreditos(){
        return lineaCreditos;
    }
    public void addLineaCredito(LineaCreditoModel lineaCredito){
        lineaCreditos.add(lineaCredito);
    }

    public LineaCreditoModel getLineaCreditosById(int id){
        for(LineaCreditoModel lineaCredito: lineaCreditos){
            if(lineaCredito.getId() == id){
                return lineaCredito;
            }
        }

        return null;
    }

    // Sets
    public void setNombreUsuario(String nombre){
        nombreUsuario = nombre;
    }

    public void setRazonSocial(String razonSocial){
        this.razonSocial = razonSocial;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa){
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

    public void setEstadoSocio(EstadoSocio estado){
        this.estado = estado;
    }

    public void setTipoSocio(TipoSocio tipoSocio){
        this.tipoSocio = tipoSocio;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento){
        this.tipoDocumento = tipoDocumento;
    }

    public void setCuit(String cuit){
        this.cuit = cuit;
    }

    public void setActividadPrincipal(String actividadPrincipal){
        this.actividadPrincipal = actividadPrincipal;
    }

    public ArrayList<AccionistaModel> getAccionistas() {
        return accionistas;
    }

    public void setAccionistas(ArrayList<AccionistaModel> accionistas) {
        this.accionistas = accionistas;
    }

    public EstadoDocumento getEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(EstadoDocumento estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }

    public void addAporte(AporteModel aporte){
        aportes.add(aporte);
    }
}
