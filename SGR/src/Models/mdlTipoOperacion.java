package Models;

import Models.Enums.TipoOperacion;
import Models.Enums.NumeracionTipoOperacion;

public class mdlTipoOperacion {
    private TipoOperacion tipoOperacion;
    private NumeracionTipoOperacion numeracionTipoOperacion;
    private OperacionModel operacion;

    public void CrearTipoOperacion(TipoOperacion _tipoOperacion, NumeracionTipoOperacion _numeracionTipoOperacion){
        tipoOperacion = _tipoOperacion;
        numeracionTipoOperacion = _numeracionTipoOperacion;
    }

    public TipoOperacion getTipoOperacion(){
        return tipoOperacion;
    }

    public OperacionModel getOperacion(){
        return operacion;
    }

    public NumeracionTipoOperacion getNumeracionTipoOperacion() {
        return numeracionTipoOperacion;
    }
}
