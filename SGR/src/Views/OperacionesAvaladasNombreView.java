package Views;

import Controllers.*;
import Models.*;
import Models.Enums.EstadoOperacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class OperacionesAvaladasNombreView extends JDialog {
    private JPanel pnlPrincipal;
    private JButton cerrarButton;
    private JTable table1;
    private JTextField txtDesde;
    private JTextField txtHasta;
    private JComboBox cmbSocios;
    private JButton buscarButton;
    private final SocioController socioController;
    private final DefaultTableModel model;

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
            cmbSocios.addItem(socio.getCuit());
        };

        model = new DefaultTableModel();
        model.addColumn("Tipo Operacion");
        model.addColumn("Fecha");
        model.addColumn("Importe");
        table1.setModel(model);
    }

    private void BorrarRows(){
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
    }

    private void asociarEventos() {
        cerrarButton.addActionListener(e -> dispose());

        buscarButton.addActionListener(e -> {
            try {
                BorrarRows();
                var socio = socioController.getSociosByCuit(Objects.requireNonNull(cmbSocios.getSelectedItem()).toString());
                for(LineaCreditoModel lineaCredito: socio.getLineaCreditos()){
                    for(OperacionModel operacion : lineaCredito.getCheques()){
                        if ((new SimpleDateFormat("dd/MM/yyyy").parse(txtDesde.getText())).before(operacion.getFecha()) &&
                                (new SimpleDateFormat("dd/MM/yyyy").parse(txtHasta.getText())).after(operacion.getFecha())
                                && operacion.getEstadoOperacion() == EstadoOperacion.Monetizado) {
                            model.addRow(new Object[]{operacion.getTipoOperacion(), operacion.getFecha(), operacion.getImportePagado()});
                        }
                    }
                    for(OperacionModel operacion : lineaCredito.getCuentaCorrientes()){
                        if ((new SimpleDateFormat("dd/MM/yyyy").parse(txtDesde.getText())).before(operacion.getFecha()) &&
                                (new SimpleDateFormat("dd/MM/yyyy").parse(txtHasta.getText())).after(operacion.getFecha())
                                && operacion.getEstadoOperacion() == EstadoOperacion.Monetizado) {
                            model.addRow(new Object[]{operacion.getTipoOperacion(), operacion.getFecha(), operacion.getImportePagado()});
                        }
                    }
                    for(OperacionModel operacion : lineaCredito.getPrestamos()){
                        if ((new SimpleDateFormat("dd/MM/yyyy").parse(txtDesde.getText())).before(operacion.getFecha()) &&
                                (new SimpleDateFormat("dd/MM/yyyy").parse(txtHasta.getText())).after(operacion.getFecha())
                                && operacion.getEstadoOperacion() == EstadoOperacion.Monetizado) {
                            model.addRow(new Object[]{operacion.getTipoOperacion(), operacion.getFecha(), operacion.getImportePagado()});
                        }
                    }
                }

                table1.setModel(model);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() + "No se encontraron resultados para su busqueda");
            }
        });
    }
}
