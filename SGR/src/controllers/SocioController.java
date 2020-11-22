package Controllers;

import Models.*;
import java.util.ArrayList;

public class SocioController {
    private static final SocioController INSTANCE = new SocioController();

    private ArrayList<SocioModel> socios;

    private SocioController(){
        socios = new ArrayList<>();
    }

    public static SocioController getInstance() {
        return INSTANCE;
    }

    public  void AddSocio(SocioModel socio){
        socios.add(socio);
    }

    public ArrayList<SocioModel> getSocios(){
        return  socios;
    }

    public SocioModel getSociosByCuit(String cuit){
        for (SocioModel socio:socios) {
            if(socio.getCuit().matches(cuit)) {
                return socio;
            }
        };

        return null;
    }
}
