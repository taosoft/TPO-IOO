package controllers;

import modelos.*;

import java.util.ArrayList;

public class ctrOperacion {
    private ArrayList<mdlCheque> cheques;
    private ArrayList<mdlCuentaCorriente> cuentaCorrientes;
    private ArrayList<mdlPrestamo> prestamos;

    public ctrOperacion(){
        cheques = new ArrayList<mdlCheque>();
        cuentaCorrientes = new ArrayList<mdlCuentaCorriente>();
        prestamos = new ArrayList<mdlPrestamo>();
    }

    public void addOperacion(mdlCheque cheque){
        cheques.add(cheque);
    }
    public void addOperacion(mdlCuentaCorriente cuentaCorriente){ cuentaCorrientes.add(cuentaCorriente);}
    public void addOperacion(mdlPrestamo prestamo){prestamos.add(prestamo);}

    public ArrayList<mdlCheque> getCheques() { return cheques; }
    public ArrayList<mdlCuentaCorriente> getCuentaCorrientes() { return cuentaCorrientes; }
    public ArrayList<mdlPrestamo> getPrestamos() { return prestamos; }
}
