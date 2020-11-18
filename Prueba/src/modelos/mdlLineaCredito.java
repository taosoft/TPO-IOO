package modelos;

import java.util.ArrayList;
import java.util.Date;

public class mdlLineaCredito {

    private Date fechaVigencia;
    private long monto;
    private ArrayList<mdlTipoOperacion> tipoOperaciones;
    private ArrayList<mdlCheque> cheques;
    private ArrayList<mdlCuentaCorriente> cuentaCorrientes;
    private ArrayList<mdllPrestamo> prestamos;

    public mdlLineaCredito(){
        tipoOperaciones = new ArrayList<>();
        cheques = new ArrayList<>();
        cuentaCorrientes = new ArrayList<>();
        prestamos = new ArrayList<>();
    }


    public void CrearSocio(Date _fechaVigencia, long _monto, ArrayList<mdlTipoOperacion> _tipoOperaciones){
        fechaVigencia = _fechaVigencia;
        monto = _monto;
        tipoOperaciones = _tipoOperaciones;
    }

    public ArrayList<mdlCheque> getCheques() {
        return cheques;
    }

    public int getTotalOperacion(){

        int contadorOperaciones = 0;

        // Recorro la lista del tipo de operaciones
        for (mdlCheque cheque: cheques) {
            if(fechaVigencia.before(new Date()) && cheque.getEstadoOperacion() == estadoOperacion.Monetizado){
                contadorOperaciones += cheque.getImportePagado();
            }
        }

        for (mdlCuentaCorriente cuentaCorriente: cuentaCorrientes) {
            if(fechaVigencia.before(new Date()) && cuentaCorriente.getEstadoOperacion() == estadoOperacion.Monetizado) {
                contadorOperaciones += cuentaCorriente.getImportePagado();
            }
        }

        for (mdllPrestamo prestamo: prestamos) {
            if(fechaVigencia.before(new Date()) && prestamo.getEstadoOperacion() == estadoOperacion.Monetizado) {
                contadorOperaciones += prestamo.getImportePagado();
            }
        }

        return contadorOperaciones;
    }

    public int getTotalUtilizado(){

        int contadorOperaciones = 0;

        // Recorro la lista del tipo de operaciones
        for (mdlCheque cheque: cheques) {
            //
            if(cheque.getEstadoOperacion() == estadoOperacion.ConCertificadoEmitido){
                contadorOperaciones += cheque.getImportePagado();
            }
        }

        for (mdlCuentaCorriente cuentaCorriente: cuentaCorrientes) {
            if(cuentaCorriente.getEstadoOperacion() == estadoOperacion.ConCertificadoEmitido) {
                contadorOperaciones += cuentaCorriente.getImportePagado();
            }
        }

        for (mdllPrestamo prestamo: prestamos) {
            if(prestamo.getEstadoOperacion() == estadoOperacion.ConCertificadoEmitido) {
                contadorOperaciones += prestamo.getImportePagado();
            }
        }

        return contadorOperaciones;
    }

    public Date getFechaVigencia(){
        return fechaVigencia;
    }

    public long getMonto(){
        return monto;
    }

    public ArrayList<mdlTipoOperacion> getTipoOperaciones(){
        return tipoOperaciones;
    }
}
