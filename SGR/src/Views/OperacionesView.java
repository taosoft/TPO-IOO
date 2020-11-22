package Views;

import Models.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OperacionesView extends JDialog {
    private JButton chequesButton;
    private JButton prestamosButton;
    private JButton CCComercialesButton;
    private JTable table1;
    private JButton cerrarButton;
    private JButton aceptarButton;
    private JPanel pnlOperaciones;
    private JPanel pnlOperac;
    private PrestamoView self;

    public OperacionesView(Window owner, LineaCreditoModel LineaCreditoModel) {
        super(owner);
        this.setContentPane(pnlOperaciones);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        //this.self = this;

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Operacion");
        model.addColumn("Importe");
        model.addColumn("Tasa");
        model.addColumn("Fecha Acreditada");
        model.addColumn("Fecha vto");
        model.addColumn("Estado");

        model.addRow(new Object[]{"Préstamo","100.000","-","05/04/2020","05/06/2020","Con certificado emitido"});
        model.addRow(new Object[]{"Cuenta corriente","Inversion","07/05/2020","Ingresado"});
        model.addRow(new Object[]{"Deposito","Inversion","04/06/2020","Con certificado emitido"});
        model.addRow(new Object[]{"Deposito","Capitalizacion","25/08/2020","Pendiente"});

        table1.setModel(model);

        cerrarButton.addActionListener(e -> dispose());

        chequesButton.addActionListener(e -> {
            ChequeView frame = new ChequeView(self, new LineaCreditoModel(1));
            frame.setVisible(true);
        });

        CCComercialesButton.addActionListener(e -> {
            CuentasCorrienteView frame = new CuentasCorrienteView(self);
            frame.show();
        });

        prestamosButton.addActionListener(e -> {
            PrestamoView frame = new PrestamoView(self, LineaCreditoModel.getPrestamos());
            frame.setVisible(true);
        });
    }
}
