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

<<<<<<< HEAD
    public mdlLineaCredito() {
=======
    public mdlLineaCredito(int id){
>>>>>>> 250206968b18e341e146595df89a6cd850b0c531
        tipoOperaciones = new ArrayList<>();
        cheques = new ArrayList<>();
        cuentaCorrientes = new ArrayList<>();
        prestamos = new ArrayList<>();
        this.id = id;
    }

<<<<<<< HEAD

    public static mdlLineaCredito crearLineaCredito(Date _fechaVigencia, long _monto, ArrayList<mdlTipoOperacion> _tipoOperaciones,
                                                    ArrayList<mdlCheque> _cheques, ArrayList<mdlPrestamo> _prestamos, ArrayList<mdlCuentaCorriente> _cuentaCorrientes) {


        var lineaCredito = new mdlLineaCredito();

        lineaCredito.fechaVigencia = _fechaVigencia;
        lineaCredito.monto = _monto;
        lineaCredito.tipoOperaciones = _tipoOperaciones;
        lineaCredito.tipoOperaciones = _tipoOperaciones;
        lineaCredito.cheques = _cheques;
        lineaCredito.cuentaCorrientes = _cuentaCorrientes;
        lineaCredito.prestamos = _prestamos;

        return lineaCredito;
    }       
    
=======
    public static mdlLineaCredito crearLineaCredito(Date _fechaVigencia, long _monto, ArrayList<tipoOperacion> _tipoOperaciones, int id){

        var lineaCredito = new mdlLineaCredito(id);
        lineaCredito.fechaVigencia = _fechaVigencia;
        lineaCredito.monto = _monto;
        lineaCredito.tipoOperaciones = _tipoOperaciones;

        return lineaCredito;
    }
>>>>>>> 250206968b18e341e146595df89a6cd850b0c531

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

<<<<<<< HEAD
    public ArrayList<mdlTipoOperacion> getTipoOperaciones() {
=======
    public ArrayList<tipoOperacion> getTipoOperaciones(){
>>>>>>> 250206968b18e341e146595df89a6cd850b0c531
        return tipoOperaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
