package Controllers;

import Models.*;
import java.util.ArrayList;

public class SgrController {
    private static final SgrController INSTANCE = new SgrController();

    private ArrayList<SocioModel> socios;
    private ArrayList<LineaCreditoModel> lineaCreditos;

    private ArrayList<LogEstadoSocioModel> logsEstadoSocioModel;
    private ArrayList<LogDocumentoSocioModel> logsDocumentoSocioModels;
    private ArrayList<LogEstadoDocumentoSocioModel> logsEstadoDocumentoSocioModel;

    private SgrController() {
        socios = new ArrayList<>();
        lineaCreditos = new ArrayList<>();

        logsEstadoSocioModel = new ArrayList<>();
        logsDocumentoSocioModels = new ArrayList<>();
        logsEstadoDocumentoSocioModel = new ArrayList<>();
    }

    public static SgrController getInstance() {
        return INSTANCE;
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

    public ArrayList<LogEstadoSocioModel> getLogsEstadoSocioModel() {
        return logsEstadoSocioModel;
    }

    public void setLogsEstadoSocioModel(ArrayList<LogEstadoSocioModel> logsEstadoSocioModel) {
        this.logsEstadoSocioModel = logsEstadoSocioModel;
    }

    public void addLogEstadoSocioModel(LogEstadoSocioModel logEstadoSocioModel){
        logsEstadoSocioModel.add(logEstadoSocioModel);
    }

    public ArrayList<LogDocumentoSocioModel> getLogsDocumentoSocioModels() {
        return logsDocumentoSocioModels;
    }

    public void setLogsDocumentoSocioModels(ArrayList<LogDocumentoSocioModel> logsDocumentoSocioModels) {
        this.logsDocumentoSocioModels = logsDocumentoSocioModels;
    }

    public void addLogDocumentoSocioModel(LogDocumentoSocioModel logDocumentoSocioModel){
        logsDocumentoSocioModels.add(logDocumentoSocioModel);
    }

    public ArrayList<LogEstadoDocumentoSocioModel> getLogsEstadoDocumentoSocioModel() {
        return logsEstadoDocumentoSocioModel;
    }

    public void setLogsEstadoDocumentoSocioModel(ArrayList<LogEstadoDocumentoSocioModel> logsEstadoDocumentoSocioModel) {
        this.logsEstadoDocumentoSocioModel = logsEstadoDocumentoSocioModel;
    }

    public void addLogEstadoDocumentoSocioModel(LogEstadoDocumentoSocioModel logEstadoDocumentoSocioModel){
        logsEstadoDocumentoSocioModel.add(logEstadoDocumentoSocioModel);
    }
}
