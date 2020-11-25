package Views;

import Controllers.*;
import Models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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
    }

    private void asociarEventos(){
        salirButton.addActionListener(e -> dispose());

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
}