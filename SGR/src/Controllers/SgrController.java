package Controllers;

import Models.*;
import java.util.ArrayList;

public class SgrController {
    private static final SgrController INSTANCE = new SgrController();

    private final ArrayList<SocioModel> socios;

    private ArrayList<LogEstadoSocioModel> logsEstadoSocioModel;
    private ArrayList<LogDocumentoSocioModel> logsDocumentoSocioModel;
    private ArrayList<LogEstadoDocumentoSocioModel> logsEstadoDocumentoSocioModel;
    private ArrayList<LogOperacionModel> logsOperacionModel;
    private ArrayList<LogComisionModel> logsComisionModel;

    private SgrController() {
        socios = SocioController.getInstance().getSocios();

        logsEstadoSocioModel = new ArrayList<>();
        logsDocumentoSocioModel = new ArrayList<>();
        logsEstadoDocumentoSocioModel = new ArrayList<>();
        logsOperacionModel = new ArrayList<>();
        logsComisionModel = new ArrayList<>();
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
            if(socioLista.getCuit().equals(cuit))
                socio = socioLista;
        }

        int contadorUtilizadoLinea = 0;

        for (LineaCreditoModel lineaCredito: socio.getLineaCreditos()) {
            contadorUtilizadoLinea += 0;
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
        return logsDocumentoSocioModel;
    }

    public void setLogsDocumentoSocioModels(ArrayList<LogDocumentoSocioModel> logsDocumentoSocioModels) {
        this.logsDocumentoSocioModel = logsDocumentoSocioModels;
    }

    public void addLogDocumentoSocioModel(LogDocumentoSocioModel logDocumentoSocioModel){
        logsDocumentoSocioModel.add(logDocumentoSocioModel);
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

    public ArrayList<LogOperacionModel> getLogsOperacionModel() {
        return logsOperacionModel;
    }

    public void setLogsOperacionModel(ArrayList<LogOperacionModel> logsOperacionModel) {
        this.logsOperacionModel = logsOperacionModel;
    }

    public void addLogOperacionModel(LogOperacionModel logOperacionModel){
        logsOperacionModel.add(logOperacionModel);
    }

    public ArrayList<LogComisionModel> getLogsComisionModel() {
        return logsComisionModel;
    }

    public void setLogsComisionModel(ArrayList<LogComisionModel> logsComisionModel) {
        this.logsComisionModel = logsComisionModel;
    }

    public void addLogComisionModel(LogComisionModel logComisionModel) {
        logsComisionModel.add(logComisionModel);
    }
}
