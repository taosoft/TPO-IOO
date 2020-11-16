package controllers;


import modelos.mdlLineaCredito;

import java.util.ArrayList;

public class ctrLineaCredito {
    private ArrayList<mdlLineaCredito> lineaCreditos;

    public ctrLineaCredito(){
        lineaCreditos = new ArrayList<mdlLineaCredito>();
    }

    public  void AddLineaCredito(mdlLineaCredito lineaCredito){
        lineaCreditos.add(lineaCredito);
    }

    public ArrayList<mdlLineaCredito> getLineaCreditos(){
        return  lineaCreditos;
    }
}
