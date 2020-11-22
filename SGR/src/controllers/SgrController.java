package Controllers;

import Models.*;
import java.util.ArrayList;

public class SgrController {
    private static final SgrController INSTANCE = new SgrController();

    private ArrayList<SocioModel> socios;
    private ArrayList<LineaCreditoModel> lineaCreditos;
    private ArrayList<mdlOperacion> operaciones;
    private ArrayList<mdlTipoOperacion> tipoOperaciones;
    
    private SgrController() {
        socios = new ArrayList<>();
        lineaCreditos = new ArrayList<>();
    }

    public static SgrController getInstance() {
        return INSTANCE;
    }

    public void addSocio(SocioModel socio){
        socios.add(socio);
    }

    public void addLineaCredio(LineaCreditoModel lineaCredito){
        lineaCreditos.add(lineaCredito);
    }

    public void addOperacion(mdlOperacion operacion){
        operaciones.add(operacion);
    }
    
    public void addTipoOperacion(mdlTipoOperacion tipoOperacion){
        tipoOperaciones.add(tipoOperacion);
    }

    public int getConsolidadas(String cuit){

        SocioModel socio = new SocioModel();

        // Obtengo el socio de la lista de socios
        for(SocioModel socioLista: socios){
                if(socioLista.getCuit() == cuit)
                    socio = socioLista;                
            }

        int contadorRiesgoVivo = 0;

        for (LineaCreditoModel lineaCredito: socio.getLineaCreditos()) {
            contadorRiesgoVivo += lineaCredito.getTotalOperacion();
        }

        return contadorRiesgoVivo;
    }

    public int getTotalUtilizado(String cuit){

        SocioModel socio = new SocioModel();

        // Obtengo el socio de la lista de socios
        for(SocioModel socioLista: socios){
            if(socioLista.getCuit() == cuit)
                socio = socioLista;
        }

        int contadorUtilizadoLinea = 0;

        for (LineaCreditoModel lineaCredito: socio.getLineaCreditos()) {
            contadorUtilizadoLinea += lineaCredito.getTotalOperacion();
        }

        return contadorUtilizadoLinea;
    }
}
