package modelos;

import java.util.ArrayList;
import java.util.Date;

public class mdlLineaCredito {

    private Date fechaVigencia;
    private long monto;
    private ArrayList<mdlTipoOperacion> tipoOperaciones;

    public void CrearSocio(Date _fechaVigencia, long _monto, ArrayList<mdlTipoOperacion> _tipoOperaciones){
        fechaVigencia = _fechaVigencia;
        monto = _monto;
        tipoOperaciones = _tipoOperaciones;
    }


    public int getTotalOperacion(mdlSocio _socio){

        int contadorOperaciones = 0;

        // Recorro la lista del tipo de operaciones
        for (mdlTipoOperacion tipoOperacionLista: tipoOperaciones) {
            // Consulto si el tipo de operación es igual al que posee la línea de crédito
            if(tipoOperacionLista.toString() == tipoOperacionLista.getOperacion().getTipo())
            {
                contadorOperaciones++;
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
