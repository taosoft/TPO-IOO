package controllers;

import modelos.mdlTipoOperacion;
import java.util.ArrayList;

public class ctrTipoOperacion {
    private ArrayList<mdlTipoOperacion> tipoOperaciones;

    public ctrTipoOperacion(){
        tipoOperaciones = new ArrayList<mdlTipoOperacion>();
    }

    public  void AddLineaCredito(mdlTipoOperacion tipoOperacion){
        tipoOperaciones.add(tipoOperacion);
    }

    public ArrayList<mdlTipoOperacion> getTipoOperaciones(){
        return tipoOperaciones;
    }
}