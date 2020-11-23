package Views;

import Controllers.*;
import Models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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

        socioController = SocioController.getInstance();

        lineaCredito = socioController.getSociosByCuit(cuit).getLineaCreditosById(idLineaCredito);

        model = new DefaultTableModel();
        model.addColumn("Operacion");
        model.addColumn("Importe");
        model.addColumn("Fecha Acreditada");
        model.addColumn("Fecha Vencimiento");
        model.addColumn("Estado");

        LoadTabla();
    }

    private void asociarEventos() {
        cerrarButton.addActionListener(e -> dispose());

        chequesButton.addActionListener(e -> {
            ChequeView frame = new ChequeView(self, new LineaCreditoModel());
            frame.setVisible(true);
        });

        CCComercialesButton.addActionListener(e -> {
            CuentasCorrienteView frame = new CuentasCorrienteView(self);
            frame.show();
        });

        prestamosButton.addActionListener(e -> {
            PrestamoView frame = new PrestamoView(self, lineaCredito.getPrestamos());
            frame.setVisible(true);
        });
    }

    private void LoadTabla() {
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

        //TODO: Delete
        model.addRow(new Object[]{"Préstamo","100.000","-","05/04/2020","05/06/2020"});
        model.addRow(new Object[]{"Cuenta corriente","Inversion","07/05/2020","Ingresado"});
        model.addRow(new Object[]{"Deposito","Inversion","04/06/2020","Con certificado emitido"});
        model.addRow(new Object[]{"Deposito","Capitalizacion","25/08/2020","Pendiente"});
        //

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
