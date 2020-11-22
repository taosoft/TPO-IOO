package modelos;

import java.util.ArrayList;
import java.util.Date;

public class mdlLineaCredito {

    private Date fechaVigencia;
    private long monto;
    private int id;
    private ArrayList<tipoOperacion> tipoOperaciones;
    private ArrayList<mdlCheque> cheques;
    private ArrayList<mdlCuentaCorriente> cuentaCorrientes;
    private ArrayList<mdlPrestamo> prestamos;

    public mdlLineaCredito(int id){
        tipoOperaciones = new ArrayList<>();
        cheques = new ArrayList<>();
        cuentaCorrientes = new ArrayList<>();
        prestamos = new ArrayList<>();
        this.id = id;
    }

    public static mdlLineaCredito crearLineaCredito(Date _fechaVigencia, long _monto, ArrayList<tipoOperacion> _tipoOperaciones, int id){

        var lineaCredito = new mdlLineaCredito(id);
        lineaCredito.fechaVigencia = _fechaVigencia;
        lineaCredito.monto = _monto;
        lineaCredito.tipoOperaciones = _tipoOperaciones;

        return lineaCredito;
    }

    public ArrayList<mdlCheque> getCheques() {
        return cheques;
    }

    public ArrayList<mdlPrestamo> getPrestamos() {
        return prestamos;
    }

    public void addCheque(mdlCheque cheque){
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
        for (mdlCheque cheque : cheques) {
            if (fechaVigencia.before(new Date()) && cheque.getEstadoOperacion() == estadoOperacion.Monetizado) {
                contadorOperaciones += cheque.getImportePagado();
            }
        }

        for (mdlCuentaCorriente cuentaCorriente : cuentaCorrientes) {
            if (fechaVigencia.before(new Date()) && cuentaCorriente.getEstadoOperacion() == estadoOperacion.Monetizado) {
                contadorOperaciones += cuentaCorriente.getImportePagado();
            }
        }

        for (mdlPrestamo prestamo : prestamos) {
            if (fechaVigencia.before(new Date()) && prestamo.getEstadoOperacion() == estadoOperacion.Monetizado) {
                contadorOperaciones += prestamo.getImportePagado();
            }
        }

        return contadorOperaciones;
    }

    public int getTotalUtilizado() {

        int contadorOperaciones = 0;

        // Recorro la lista del tipo de operaciones
        for (mdlCheque cheque : cheques) {
            //
            if (cheque.getEstadoOperacion() == estadoOperacion.ConCertificadoEmitido) {
                contadorOperaciones += cheque.getImportePagado();
            }
        }

        for (mdlCuentaCorriente cuentaCorriente : cuentaCorrientes) {
            if (cuentaCorriente.getEstadoOperacion() == estadoOperacion.ConCertificadoEmitido) {
                contadorOperaciones += cuentaCorriente.getImportePagado();
            }
        }

        for (mdlPrestamo prestamo : prestamos) {
            if (prestamo.getEstadoOperacion() == estadoOperacion.ConCertificadoEmitido) {
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

    public ArrayList<tipoOperacion> getTipoOperaciones(){
        return tipoOperaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}