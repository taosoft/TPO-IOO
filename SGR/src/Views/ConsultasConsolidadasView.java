package Views;

import Controllers.*;
import Models.*;
import Models.Enums.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;

public class ConsultasConsolidadasView extends JDialog {
    private JPanel pnlPrincipal;
    private JTable table1;
    private JComboBox comboBox1;
    private JButton buscarButton;
    private JButton salirButton;
    private ConsultasConsolidadasView self;
    private SocioController socioController;
    private SgrController sgrController;

    public ConsultasConsolidadasView(Window owner) {
        super(owner);
        //De esa forma le digo que el pnlPrincipal es el primero que se va a iniciar y le va a dar el contenido a mi pantalla.
        this.setContentPane(pnlPrincipal);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        this.asociarEventos();
        this.self = this;

        socioController = SocioController.getInstance();
        sgrController = SgrController.getInstance();

        cargarListaSocios();

        for (SocioModel socio:socioController.getSocios()) {
            comboBox1.addItem(socio.getCuit());
        };

        buscarButton.addActionListener(e -> {
            var cuit = comboBox1.getSelectedItem();

            int totalRiesgoVivo = sgrController.getConsolidadas(cuit.toString());
            int totalUtilizadoLinea = totalRiesgoVivo + sgrController.getTotalUtilizado(cuit.toString());

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Socios");
            model.addColumn("Riesgo Vivo");
            model.addColumn("Total Reutilizado");

            model.addRow(new Object[]{cuit,totalRiesgoVivo,totalUtilizadoLinea});

            table1.setModel(model);
        });
    }

    private void cargarListaSocios(){

        var socio = SocioModel.CrearSocio("Mario","30715645579","Empresa S.A.", TipoEmpresa.Mediana,
                "comercialización", "libertadores 123","353535","dasd@sadas.com",
                new Date("13/10/2014"), TipoSocio.Participe);

        socioController.AddSocio((socio));

        socio = SocioModel.CrearSocio("Juan","30801032158","Luz S.A.", TipoEmpresa.Mediana,
                "comercialización", "Chacabuco 123","353535","dasd@sadas.com",
                new Date("26/09/2016"), TipoSocio.Participe);

        socioController.AddSocio((socio));

        socio = SocioModel.CrearSocio("Martha","30715248547","La Risa SRL.", TipoEmpresa.Grande,
                "Cotillon", "Rivadavia 4123","45484542","lalal@sadas.com",
                new Date("03/04/2008"), TipoSocio.Protector);

        socioController.AddSocio((socio));

        socio = SocioModel.CrearSocio("Ledesma","27542547852","Gandoriza SA", TipoEmpresa.Pequena,
                "Turismo", "Larralde 4251","151254215","dasd@sadas.com",
                new Date("12/10/2012"), TipoSocio.Participe);

        socioController.AddSocio((socio));
    }

    private ChequeModel cargarCheque(SocioModel socio){
        var certificadoGarantia = mdlCertificadoGarantia.crearCertificadoGarantia(2);

        var comision = mdlComision.crearComision("1",new Date("10/11/2020"), EstadoComision.Calculada,"3%", "Mario");

        var cheque = new ChequeModel();

        cheque.crearOperacion(TipoOperacion.ChequePropio,certificadoGarantia,socio,comision, EstadoOperacion.Monetizado,new Date("10/11/2020"));
        cheque.crearOperacion(TipoOperacion.ChequeTerceros,certificadoGarantia,socio,comision, EstadoOperacion.Ingresado,new Date("10/11/2020"));

        return  cheque;
    }

    private mdlPrestamo cargarPrestamo(SocioModel socio){
        var certificadoGarantia = mdlCertificadoGarantia.crearCertificadoGarantia(3);

        var comision = mdlComision.crearComision("1",new Date("10/11/2020"), EstadoComision.Calculada,"3%", "Mario");

        var prestamo = new mdlPrestamo();
        prestamo.crearOperacion(TipoOperacion.Prestamo,certificadoGarantia,socio,comision, EstadoOperacion.Monetizado,new Date("10/11/2020"));

        return  prestamo;
    }

    private mdlCuentaCorriente cargarCuentaCorriente(SocioModel socio){
        var certificadoGarantia = mdlCertificadoGarantia.crearCertificadoGarantia(5);

        var comision = mdlComision.crearComision("1",new Date("10/11/2020"), EstadoComision.Calculada,"3%", "Mario");

        var cuentaCorriente = new mdlCuentaCorriente();
        cuentaCorriente.crearOperacion(TipoOperacion.CCComercial,certificadoGarantia,socio,comision, EstadoOperacion.Monetizado,new Date("10/11/2020"));

        return  cuentaCorriente;
    }

    private void asociarEventos(){
        salirButton.addActionListener(e -> dispose());
    }
}