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
        this.setTitle("Consultas consolidadas");

        socioController = SocioController.getInstance();
        sgrController = SgrController.getInstance();

        for (SocioModel socio:socioController.getSocios()) {
            cmbSocios.addItem(socio.getCuit());
        };

        buscarButton.addActionListener(e -> {
            var cuit = cmbSocios.getSelectedItem();

            assert cuit != null;
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
        var certificadoGarantia = CertificadoGarantiaModel.crearCertificadoGarantia(2);

        var comision = ComisionModel.crearComision("1",new Date("10/11/2020"), EstadoComision.Calculada,"3%", "Mario");

        var cheque = new ChequeModel();

        OperacionModel.CrearOperacion(TipoOperacion.ChequePropio,certificadoGarantia,comision, new Date());
        OperacionModel.CrearOperacion(TipoOperacion.ChequeTerceros,certificadoGarantia,comision, new Date());

        return  cheque;
    }

    private PrestamoModel cargarPrestamo(SocioModel socio){
        var certificadoGarantia = CertificadoGarantiaModel.crearCertificadoGarantia(3);

        var comision = ComisionModel.crearComision("1",new Date("10/11/2020"), EstadoComision.Calculada,"3%", "Mario");

        var prestamo = new PrestamoModel();
        OperacionModel.CrearOperacion(TipoOperacion.Prestamo,certificadoGarantia,comision, new Date());

        return  prestamo;
    }

    private CuentaCorrienteModel cargarCuentaCorriente(SocioModel socio){
        var certificadoGarantia = CertificadoGarantiaModel.crearCertificadoGarantia(5);

        var comision = ComisionModel.crearComision("1",new Date("10/11/2020"),
                EstadoComision.Calculada,"3%", "Mario");

        var cuentaCorriente = new CuentaCorrienteModel();
        cuentaCorriente.CrearOperacion(TipoOperacion.CCComercial,certificadoGarantia,comision, new Date());

        return  cuentaCorriente;
    }

    private void asociarEventos(){
        salirButton.addActionListener(e -> dispose());
    }
}