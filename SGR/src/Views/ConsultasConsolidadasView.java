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
    private JComboBox cmbSocios;
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

        for (SocioModel socio:socioController.getSocios()) {
            cmbSocios.addItem(socio.getCuit());
        };

        buscarButton.addActionListener(e -> {
            var cuit = cmbSocios.getSelectedItem();

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