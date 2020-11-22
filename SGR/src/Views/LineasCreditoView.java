package Views;

import Controllers.SocioController;
import Models.*;
import Models.Enums.TipoOperacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LineasCreditoView extends JDialog {

    private JLabel lblCliente;
    private JTable table1;
    private JButton cerrarButton;
    private JPanel pnlLineaCredito;
    private JButton operarButton;
    private JButton agregarButton;
    private LineasCreditoView self;
    private SocioController socioController;

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

        socioController = SocioController.getInstance();

        lblCliente.setText(cuit);

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Tipo operaciones");
        model.addColumn("Monto");
        model.addColumn("Fecha");

        for(LineaCreditoModel lineaCredito: socioController.getSociosByCuit(cuit).getLineaCreditos()){
            String tipoOperacionesConcat = new String();
            for(TipoOperacion tipoOperacion: lineaCredito.getTipoOperaciones()){
                tipoOperacionesConcat += tipoOperacion.toString();
            }
            model.addRow(new Object[]{tipoOperacionesConcat,lineaCredito.getMonto(), lineaCredito.getFechaVigencia(), lineaCredito.getId()});
        }
        table1.setModel(model);

        cerrarButton.addActionListener(e -> dispose());

        operarButton.addActionListener(e -> {
            //Integer.parseInt(table1.getModel().getValueAt(table1.getSelectedRow(),4).toString()
            var lineaCredito = socioController.getSociosByCuit(cuit).getLineaCreditosById(1);
            OperacionesView frame = new OperacionesView(self, lineaCredito);
            frame.setVisible(true);
        });

        agregarButton.addActionListener(e -> {

        });
    }
}
