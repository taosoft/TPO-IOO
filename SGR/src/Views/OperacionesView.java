package Views;

import Controllers.*;
import Models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OperacionesView extends JDialog {
    private JButton chequesButton;
    private JButton prestamosButton;
    private JButton CCComercialesButton;
    private JTable tablaOperaciones;
    private JButton cerrarButton;
    private JPanel pnlOperaciones;
    private JPanel pnlOperac;
    private OperacionesView self;
    DefaultTableModel model;
    private String cuit;

    private SocioController socioController;
    private LineaCreditoModel lineaCredito;

    public OperacionesView(Window owner, String cuit, int idLineaCredito) {
        super(owner);
        this.setContentPane(pnlOperaciones);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        asociarEventos();
        this.self = this;
        this.setTitle("Operaciones");

        socioController = SocioController.getInstance();

        lineaCredito = socioController.getSociosByCuit(cuit).getLineaCreditosById(idLineaCredito);

        this.cuit = cuit;

        model = new DefaultTableModel();
        model.addColumn("Operacion");
        model.addColumn("Importe");
        model.addColumn("Fecha Acreditada");
        model.addColumn("Fecha Vencimiento");
        model.addColumn("Estado");

        LoadOperaciones();
    }

    private void asociarEventos() {
        cerrarButton.addActionListener(e -> dispose());

        chequesButton.addActionListener(e -> {
            ChequeView frame = new ChequeView(self, cuit, lineaCredito.getId());
            frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    LoadOperaciones();
                }
            });
        });

        CCComercialesButton.addActionListener(e -> {
            CuentasCorrienteView frame = new CuentasCorrienteView(self, cuit, lineaCredito.getId());
            frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    LoadOperaciones();
                }
            });
        });

        prestamosButton.addActionListener(e -> {
            PrestamoView frame = new PrestamoView(self, cuit, lineaCredito.getId());
            frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    LoadOperaciones();
                }
            });
        });
    }

    private void LoadOperaciones() {
        BorrarRows();

        for(PrestamoModel prestamo: lineaCredito.getPrestamos()){
            model.addRow(new Object[]{
                    prestamo.getTipo(), prestamo.getImportePagado(), prestamo.getFecha(),
                    prestamo.getFechaVencimiento(), prestamo.getEstadoOperacion()});
        }

        for(ChequeModel cheque: lineaCredito.getCheques()){
            model.addRow(new Object[]{
                    cheque.getTipo(), cheque.getImportePagado(), cheque.getFecha(),
                    cheque.getFechaVencimiento(), cheque.getEstadoOperacion()});
        }

        for(CuentaCorrienteModel cuentaCorriente: lineaCredito.getCuentaCorrientes()){
            model.addRow(new Object[]{
                    cuentaCorriente.getTipo(), cuentaCorriente.getImportePagado(), cuentaCorriente.getFecha(),
                    cuentaCorriente.getFechaVencimiento(), cuentaCorriente.getEstadoOperacion()});
        }

        tablaOperaciones.setModel(model);
    }

    private void BorrarRows(){
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
    }
}
