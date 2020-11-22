package Views;

import Controllers.*;
import Models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FrmConsultasConsolidadas extends JDialog {
    private JPanel pnlPrincipal;
    private JTable table1;
    private JComboBox comboBox1;
    private JButton buscarButton;
    private JButton salirButton;
    private FrmConsultasConsolidadas self;
    private SocioController SocioController;
    private SgrController SgrController;

    public FrmConsultasConsolidadas(Window owner, SocioController SocioController, SgrController sgrController) {
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
        this.SocioController = SocioController;
        this.SgrController = sgrController;

        cargarListaSocios();

        for (mdlSocio socio:this.SocioController.getSocios()) {
            comboBox1.addItem(socio.getCuit());
        };


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var cuit = comboBox1.getSelectedItem();

                int totalRiesgoVivo = sgrController.getConsolidadas(cuit.toString());
                int totalUtilizadoLinea = totalRiesgoVivo + sgrController.getTotalUtilizado(cuit.toString());

                DefaultTableModel model = new DefaultTableModel();

                model.addColumn("Socios");
                model.addColumn("Riesgo Vivo");
                model.addColumn("Total Reutilizado");

                model.addRow(new Object[]{cuit,totalRiesgoVivo,totalUtilizadoLinea});

                table1.setModel(model);

            }
        });
    }

    private void cargarListaSocios(){

        var socio = mdlSocio.CrearSocio("Mario","30715645579","Empresa S.A.",tipoEmpresa.Mediana,
                "comercialización", "libertadores 123","353535","dasd@sadas.com",
                new Date("13/10/2014"), tipoSocio.Participe);

        this.SocioController.AddSocio((socio));

        socio = mdlSocio.CrearSocio("Juan","30801032158","Luz S.A.",tipoEmpresa.Mediana,
                "comercialización", "Chacabuco 123","353535","dasd@sadas.com",
                new Date("26/09/2016"), tipoSocio.Participe);

        this.SocioController.AddSocio((socio));

        socio = mdlSocio.CrearSocio("Martha","30715248547","La Risa SRL.",tipoEmpresa.Grande,
                "Cotillon", "Rivadavia 4123","45484542","lalal@sadas.com",
                new Date("03/04/2008"), tipoSocio.Protector);

        this.SocioController.AddSocio((socio));

        socio = mdlSocio.CrearSocio("Ledesma","27542547852","Gandoriza SA",tipoEmpresa.Pequena,
                "Turismo", "Larralde 4251","151254215","dasd@sadas.com",
                new Date("12/10/2012"), tipoSocio.Participe);

        this.SocioController.AddSocio((socio));
    }

    private mdlCheque cargarCheque(mdlSocio socio){
        var certificadoGarantia = mdlCertificadoGarantia.crearCertificadoGarantia(2);

        var comision = mdlComision.crearComision("1",new Date("10/11/2020"),estadoComision.Calculada,"3%", "Mario");

        var cheque = new mdlCheque();

        cheque.crearOperacion(tipoOperacion.ChequePropio,certificadoGarantia,socio,comision,estadoOperacion.Monetizado,new Date("10/11/2020"));
        cheque.crearOperacion(tipoOperacion.ChequeTerceros,certificadoGarantia,socio,comision,estadoOperacion.Ingresado,new Date("10/11/2020"));

        return  cheque;
    }


    private mdlPrestamo cargarPrestamo(mdlSocio socio){
        var certificadoGarantia = mdlCertificadoGarantia.crearCertificadoGarantia(3);

        var comision = mdlComision.crearComision("1",new Date("10/11/2020"),estadoComision.Calculada,"3%", "Mario");

        var prestamo = new mdlPrestamo();
        prestamo.crearOperacion(tipoOperacion.Prestamo,certificadoGarantia,socio,comision,estadoOperacion.Monetizado,new Date("10/11/2020"));

        return  prestamo;
    }

    private mdlCuentaCorriente cargarCuentaCorriente(mdlSocio socio){
        var certificadoGarantia = mdlCertificadoGarantia.crearCertificadoGarantia(5);

        var comision = mdlComision.crearComision("1",new Date("10/11/2020"),estadoComision.Calculada,"3%", "Mario");

        var cuentaCorriente = new mdlCuentaCorriente();
        cuentaCorriente.crearOperacion(tipoOperacion.CCComercial,certificadoGarantia,socio,comision,estadoOperacion.Monetizado,new Date("10/11/2020"));

        return  cuentaCorriente;
    }

    private void asociarEventos(){
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
    }

}