package Models;

import Models.Enums.*;

import java.util.ArrayList;
import java.util.Date;

public class LineaCreditoModel {

    private Date fechaVigencia;
    private long monto;
    private int id;
    private ArrayList<TipoOperacion> tipoOperaciones;
    private ArrayList<ChequeModel> cheques;
    private ArrayList<CuentaCorrienteModel> cuentaCorrientes;
    private ArrayList<PrestamoModel> prestamos;

    public LineaCreditoModel(){
        tipoOperaciones = new ArrayList<>();
        cheques = new ArrayList<>();
        cuentaCorrientes = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public static LineaCreditoModel CrearLineaCredito(Date _fechaVigencia, long _monto,
                                                      ArrayList<TipoOperacion> _tipoOperaciones){

        var lineaCredito = new LineaCreditoModel();
        lineaCredito.fechaVigencia = _fechaVigencia;
        lineaCredito.monto = _monto;
        lineaCredito.tipoOperaciones = _tipoOperaciones;

        return lineaCredito;
    }

    public ArrayList<ChequeModel> getCheques() {
        return cheques;
    }

    public ChequeModel getChequeById(int id){
        for(ChequeModel cheque: cheques){
            if(cheque.getId() == id){
                return cheque;
            }
        }
        return null;
    }

    public CuentaCorrienteModel getCuentaCorrienteById(int id){
        for(CuentaCorrienteModel corrienteModel: cuentaCorrientes){
            if(corrienteModel.getId() == id){
                return corrienteModel;
            }
        }
        return null;
    }

    public PrestamoModel getPrestamoById(int id){
        for(PrestamoModel prestamo: prestamos){
            if(prestamo.getId() == id){
                return prestamo;
            }
        }
        return null;
    }

    public ArrayList<PrestamoModel> getPrestamos() {
        return prestamos;
    }

    public ArrayList<CuentaCorrienteModel> getCuentaCorrientes() {
        return cuentaCorrientes;
    }

    public void addCheque(ChequeModel cheque){
        cheque.setId(cheques.size() + 1);
        cheques.add(cheque);
    }

    public void addCuentaCorriente(CuentaCorrienteModel cuentaCorriente){
        cuentaCorriente.setId(cheques.size() + 1);
        cuentaCorrientes.add(cuentaCorriente);
    }

    public void addPrestamo(PrestamoModel prestamo){
        prestamo.setId(cheques.size() + 1);
        prestamos.add(prestamo);
    }

    public int getTotalOperacion() {
        int contadorOperaciones = 0;

        // Recorro la lista del tipo de operaciones
        for (ChequeModel cheque : cheques) {
            if (fechaVigencia.before(new Date()) && cheque.getEstadoOperacion() == EstadoOperacion.Monetizado) {
                contadorOperaciones += cheque.getImportePagado();
            }
        }

        for (CuentaCorrienteModel cuentaCorriente : cuentaCorrientes) {
            if (fechaVigencia.before(new Date()) && cuentaCorriente.getEstadoOperacion() == EstadoOperacion.Monetizado) {
                contadorOperaciones += cuentaCorriente.getImportePagado();
            }
        }

        for (PrestamoModel prestamo : prestamos) {
            if (fechaVigencia.before(new Date()) && prestamo.getEstadoOperacion() == EstadoOperacion.Monetizado) {
                contadorOperaciones += prestamo.getImportePagado();
            }
        }

        return contadorOperaciones;
    }

    public int getTotalUtilizado() {

        int contadorOperaciones = 0;

        // Recorro la lista del tipo de operaciones
        for (ChequeModel cheque : cheques) {
            //
            if (cheque.getEstadoOperacion() == EstadoOperacion.ConCertificadoEmitido) {
                contadorOperaciones += cheque.getImportePagado();
            }
        }

        for (CuentaCorrienteModel cuentaCorriente : cuentaCorrientes) {
            if (cuentaCorriente.getEstadoOperacion() == EstadoOperacion.ConCertificadoEmitido) {
                contadorOperaciones += cuentaCorriente.getImportePagado();
            }
        }

        for (PrestamoModel prestamo : prestamos) {
            if (prestamo.getEstadoOperacion() == EstadoOperacion.ConCertificadoEmitido) {
                contadorOperaciones += prestamo.getImportePagado();
            }
        }

        return contadorOperaciones;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public long getMonto() {
        return monto;
    }

    public ArrayList<TipoOperacion> getTipoOperaciones(){
        return tipoOperaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
