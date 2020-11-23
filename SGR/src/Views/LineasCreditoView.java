package Views;

import Controllers.*;
import Models.*;
import Models.Enums.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LineasCreditoView extends JDialog {

    private JLabel lblCliente;
    private JTable tablaLineaCreditos;
    private JButton cerrarButton;
    private JPanel pnlLineaCredito;
    private JButton operarButton;
    private JButton agregarButton;
    private LineasCreditoView self;
    private SocioController socioController;
    DefaultTableModel model;
    SocioModel socio;

    public LineasCreditoView(Window owner, String cuit) {
        super(owner);
        this.setContentPane(pnlLineaCredito);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        this.self = this;

        asociarEventos();

        socioController = SocioController.getInstance();
        socio = socioController.getSociosByCuit(cuit);

        lblCliente.setText(cuit);

        model = new DefaultTableModel();
        model.addColumn("Tipo operaciones");
        model.addColumn("Monto");
        model.addColumn("Fecha");
        LoadTabla();
    }

    private void LoadTabla() {
        BorrarRows();
        for(LineaCreditoModel lineaCredito: socio.getLineaCreditos()){
            StringBuilder tipoOperacionesConcat = new StringBuilder("");
            for(TipoOperacion tipoOperacion: lineaCredito.getTipoOperaciones()){
                tipoOperacionesConcat.append(tipoOperacion.toString());
            }
            model.addRow(new Object[]{
                    tipoOperacionesConcat.toString(),lineaCredito.getMonto(),
                    lineaCredito.getFechaVigencia(), lineaCredito.getId()});
        }
        tablaLineaCreditos.setModel(model);
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

        operarButton.addActionListener(e -> {
            //Integer.parseInt(table1.getModel().getValueAt(table1.getSelectedRow(),4).toString()
            var lineaCredito = socio.getLineaCreditosById(1);
            OperacionesView frame = new OperacionesView(self, lineaCredito);
            frame.setVisible(true);
        });

        agregarButton.addActionListener(e -> {

        });
    }
}
