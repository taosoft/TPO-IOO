package modelos;

import java.util.ArrayList;
import java.util.Date;

public class mdlTipoOperacion {
private tipoOperacion tipoOperacion;
private numeracionTipoOperacion numeracionTipoOperacion;

    public void CrearTipoOperacion(tipoOperacion _tipoOperacion, numeracionTipoOperacion _numeracionTipoOperacion){
        tipoOperacion = _tipoOperacion;
        numeracionTipoOperacion = _numeracionTipoOperacion;
    }

    public  tipoOperacion getTipoOperacion(){
        return tipoOperacion;
    }

    public modelos.numeracionTipoOperacion getNumeracionTipoOperacion() {
        return numeracionTipoOperacion;
    }
}
