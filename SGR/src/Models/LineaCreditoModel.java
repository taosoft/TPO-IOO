package Models;

import Models.Enums.TipoOperacion;
import Models.Enums.EstadoOperacion;

import java.util.ArrayList;
import java.util.Date;

public class LineaCreditoModel {

    private Date fechaVigencia;
    private long monto;
    private int id;
    private ArrayList<TipoOperacion> tipoOperaciones;
    private ArrayList<ChequeModel> cheques;
    private ArrayList<mdlCuentaCorriente> cuentaCorrientes;
    private ArrayList<mdlPrestamo> prestamos;

    public LineaCreditoModel(int id){
        tipoOperaciones = new ArrayList<>();
        cheques = new ArrayList<>();
        cuentaCorrientes = new ArrayList<>();
        prestamos = new ArrayList<>();
        this.id = id;
    }

    public static LineaCreditoModel crearLineaCredito(Date _fechaVigencia, long _monto, ArrayList<TipoOperacion> _tipoOperaciones, int id){

        var lineaCredito = new LineaCreditoModel(id);
        lineaCredito.fechaVigencia = _fechaVigencia;
        lineaCredito.monto = _monto;
        lineaCredito.tipoOperaciones = _tipoOperaciones;

        return lineaCredito;
    }

    public ArrayList<ChequeModel> getCheques() {
        return cheques;
    }

    public ArrayList<mdlPrestamo> getPrestamos() {
        return prestamos;
    }

    public void addCheque(ChequeModel cheque){
        cheques.add(cheque);
    }
    public void addCuentaCorriente(mdlCuentaCorriente cuentaCorriente){
        cuentaCorrientes.add(cuentaCorriente);
    }
    public void addPrestamo(mdlPrestamo prestamo){
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

        for (mdlCuentaCorriente cuentaCorriente : cuentaCorrientes) {
            if (fechaVigencia.before(new Date()) && cuentaCorriente.getEstadoOperacion() == EstadoOperacion.Monetizado) {
                contadorOperaciones += cuentaCorriente.getImportePagado();
            }
        }

        for (mdlPrestamo prestamo : prestamos) {
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

        for (mdlCuentaCorriente cuentaCorriente : cuentaCorrientes) {
            if (cuentaCorriente.getEstadoOperacion() == EstadoOperacion.ConCertificadoEmitido) {
                contadorOperaciones += cuentaCorriente.getImportePagado();
            }
        }

        for (mdlPrestamo prestamo : prestamos) {
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
