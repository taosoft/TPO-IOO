package Controllers;

import Models.*;
import java.util.ArrayList;

public class SocioController {

    private ArrayList<mdlSocio> socios;

    public SocioController(){
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
            if(socio.getCuit().matches(cuit)) {
                return socio;
            }
        };

        return null;
    }
}
