package Views;

import Controllers.*;
import Models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;

public class OperacionesAvaladasNombreView extends JDialog {
    private JPanel pnlPrincipal;
    private JButton cerrarButton;
    private JTable table1;
    private JTextField txtDesde;
    private JTextField txtHasta;
    private JComboBox comboBox1;
    private JButton buscarButton;
    private SocioController socioController;

    public OperacionesAvaladasNombreView(Window owner) {
        super(owner);
        //De esa forma le digo que el pnlPrincipal es el primero que se va a iniciar y le va a dar el contenido a mi pantalla.
        this.setContentPane(pnlPrincipal);
        this.setSize(600, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        this.asociarEventos();
        this.setTitle("Operaciones avaladas a nombre");

        socioController = SocioController.getInstance();

        for (SocioModel socio: socioController.getSocios()) {
            comboBox1.addItem(socio.getCuit());
        };

        cerrarButton.addActionListener(e -> dispose());

        buscarButton.addActionListener(e -> {

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Cuit Socio");
            model.addColumn("Razon Social");
            model.addColumn("Tipo");
            model.addColumn("Fecha");

            for(SocioModel socio: socioController.getSocios()){

                if((new Date(txtDesde.getText()).before(socio.getFechaInicioActividades())) && (new Date(txtHasta.getText()).after(socio.getFechaInicioActividades()))){
                    model.addRow(new Object[]{socio.getCuit(),socio.getRazonSocial(),socio.getTipoSocio(),socio.getFechaInicioActividades()});
                }else{
                    model.addRow(new Object[]{socio.getCuit(),socio.getRazonSocial(),socio.getTipoSocio(),new Date(socio.getFechaInicioActividades().getDate())});
                }
            }
            table1.setModel(model);
        });
    }

    private void asociarEventos() {
        cerrarButton.addActionListener(e -> dispose());
    }
}
