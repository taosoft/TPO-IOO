package Views;

import Controllers.*;
import Models.*;
import Models.Enums.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
        model.addColumn("ID");
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
                tipoOperacionesConcat.append(tipoOperacion.toString() + " \n");
            }
            model.addRow(new Object[]{
                    lineaCredito.getId(), tipoOperacionesConcat.toString(),
                    lineaCredito.getMonto(), lineaCredito.getFechaVigencia()});
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
            try{
                var idLineaCredito = Integer.parseInt(
                                tablaLineaCreditos.getModel().getValueAt(tablaLineaCreditos.getSelectedRow(),
                                        0).toString());
                OperacionesView frame = new OperacionesView(self, socio.getCuit(), idLineaCredito);
                frame.setVisible(true);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });

        agregarButton.addActionListener(e -> {
            NuevaLineaCreditoView frame = new NuevaLineaCreditoView(self, socio.getCuit());
            frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    LoadTabla();
                }
            });
        });
    }
}
