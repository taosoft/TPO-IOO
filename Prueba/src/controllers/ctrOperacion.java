package controllers;

import modelos.mdlOperacion;

import java.util.ArrayList;

public class ctrOperacion {
    private ArrayList<mdlOperacion> operaciones;

    public ctrOperacion(){
        operaciones = new ArrayList<mdlOperacion>();
    }

    public  void AddLineaCredito(mdlOperacion operacion){
        operaciones.add(operacion);
    }

    public ArrayList<mdlOperacion> getLineaCreditos(){
        return  operaciones;
    }
}