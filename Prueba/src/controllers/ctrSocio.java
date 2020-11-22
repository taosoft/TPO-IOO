package controllers;

import modelos.mdlSocio;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ctrSocio {

    private ArrayList<mdlSocio> socios;

    public ctrSocio(){
      socios = new ArrayList<mdlSocio>();

    }

    public  void AddSocio(mdlSocio socio){
        socios.add(socio);
    }

    public ArrayList<mdlSocio> getSocios(){
        return  socios;
    }

    public mdlSocio getSociosByCuit(String cuit){
        for (mdlSocio socio:socios) {
            return socio;
        };

        return null;
    }


}
