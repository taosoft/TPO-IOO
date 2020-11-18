package controllers;

import modelos.mdlLineaCredito;
import modelos.mdlOperacion;
import modelos.mdlSocio;
import modelos.mdlTipoOperacion;

import java.util.ArrayList;

public class ctrSGR {
    private ArrayList<mdlSocio> socios;
    private ArrayList<mdlLineaCredito> lineaCreditos;
    private ArrayList<mdlOperacion> operaciones;
    private ArrayList<mdlTipoOperacion> tipoOperaciones;
    
    public ctrSGR(){
        socios = new ArrayList<mdlSocio>();
        lineaCreditos = new ArrayList<mdlLineaCredito>();
    }

    public void addSocio(mdlSocio socio){
        socios.add(socio);
    }

    public void addLineaCredio(mdlLineaCredito lineaCredito){
        lineaCreditos.add(lineaCredito);
    }

    public void addOperacion(mdlOperacion operacion){
        operaciones.add(operacion);
    }
    
    public void addTipoOperacion(mdlTipoOperacion tipoOperacion){
        tipoOperaciones.add(tipoOperacion);
    }

    public int getConsolidadas(String cuit){

        mdlSocio socio = new mdlSocio();

        // Obtengo el socio de la lista de socios
        for(mdlSocio socioLista: socios){
                if(socioLista.getCuit() == cuit)
                    socio = socioLista;                
            }

        int contadorRiesgoVivo = 0;

        for (mdlLineaCredito lineaCredito: socio.getLineaCreditos()) {
            contadorRiesgoVivo += lineaCredito.getTotalOperacion();
        }

        return contadorRiesgoVivo;
    }

    public int getTotalUtilizado(String cuit){

        mdlSocio socio = new mdlSocio();

        // Obtengo el socio de la lista de socios
        for(mdlSocio socioLista: socios){
            if(socioLista.getCuit() == cuit)
                socio = socioLista;
        }

        int contadorUtilizadoLinea = 0;

        for (mdlLineaCredito lineaCredito: socio.getLineaCreditos()) {
            contadorUtilizadoLinea += lineaCredito.getTotalOperacion();
        }

        return contadorUtilizadoLinea;
    }

}
