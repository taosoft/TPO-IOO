package Controllers;

import Models.*;
import java.util.ArrayList;

public class ctrSocio {

    private ArrayList<mdlSocio> socios;

    public ctrSocio(){
      socios = new ArrayList<>();
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
