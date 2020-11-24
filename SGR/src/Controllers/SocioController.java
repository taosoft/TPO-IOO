package Controllers;

import Models.*;
import Models.Enums.TipoEmpresa;
import Models.Enums.TipoOperacion;
import Models.Enums.TipoSocio;

import java.util.ArrayList;
import java.util.Date;

public class SocioController {
    private static final SocioController INSTANCE = new SocioController();

    private ArrayList<SocioModel> socios;

    private SocioController(){
        socios = new ArrayList<>();

        AddMockedSocios();
    }

    private void AddMockedSocios() {
        var socio = SocioModel.CrearSocio("Mario","30715645579","Empresa S.A.",
                TipoEmpresa.Mediana,"comercialización", "libertadores 123","353535",
                "dasd@sadas.com", new Date("13/10/2014"), TipoSocio.Participe);

        var listaTipoOperaciones = new ArrayList<TipoOperacion>();
        listaTipoOperaciones.add(TipoOperacion.CCComercial);
        listaTipoOperaciones.add(TipoOperacion.Prestamo);
        listaTipoOperaciones.add(TipoOperacion.ChequePropio);

        var lineaCredito = LineaCreditoModel.CrearLineaCredito(new Date(),
                112,
                listaTipoOperaciones);
        socio.addLineaCredito(lineaCredito);

        socio.getLineaCreditosById(1).getCheques().add(ChequeModel.CrearNuevoCheque("Banco Nacion",
                "12345", new Date(), "301234239201", 11));

        socios.add(socio);

        socios.add(SocioModel.CrearSocio("Juan","30801032158","Luz S.A.",
                TipoEmpresa.Mediana, "comercialización","Chacabuco 123","353535",
                "dasd@sadas.com", new Date("26/09/2016"), TipoSocio.Participe));

        socios.add(SocioModel.CrearSocio("Martha","30715248547","La Risa SRL.",
                TipoEmpresa.Pequena, "Cotillon", "Rivadavia 4123","45484542",
                "lalal@sadas.com", new Date("03/04/2008"), TipoSocio.Protector));

        socios.add(SocioModel.CrearSocio("Ledesma","27542547852","Gandoriza SA",
                TipoEmpresa.Pequena,"Turismo", "Larralde 4251","151254215",
                "dasd@sadas.com", new Date("12/10/2012"), TipoSocio.Participe));
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
