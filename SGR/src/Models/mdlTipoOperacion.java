package Models;

public class mdlTipoOperacion {
    private tipoOperacion tipoOperacion;
    private numeracionTipoOperacion numeracionTipoOperacion;
    private mdlOperacion operacion;

    public void CrearTipoOperacion(tipoOperacion _tipoOperacion, numeracionTipoOperacion _numeracionTipoOperacion){
        tipoOperacion = _tipoOperacion;
        numeracionTipoOperacion = _numeracionTipoOperacion;
    }

    public  tipoOperacion getTipoOperacion(){
        return tipoOperacion;
    }

    public mdlOperacion getOperacion(){
        return operacion;
    }

    public numeracionTipoOperacion getNumeracionTipoOperacion() {
        return numeracionTipoOperacion;
    }
}
