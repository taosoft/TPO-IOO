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
