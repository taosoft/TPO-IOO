package View;

import controllers.ctrSocio;
import modelos.mdlSocio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmLineaCredito extends JDialog {

    private JLabel lblCliente;
    private JTable table1;
    private JButton cerrarButton;
    private JPanel pnlLineaCredito;


    public frmLineaCredito(Window owner, ctrSocio ctrSocio) {
        super(owner);
        this.setContentPane(pnlLineaCredito);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        //this.self = this;

        for (mdlSocio socio:ctrSocio.getSocios()) {
            lblCliente.setText(socio.getCuit());
        };

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Linea de credito");
        model.addColumn("Fecha");
        model.addColumn("Monto");
        model.addColumn("Tipo operacion");

        model.addRow(new Object[]{"N° 12542","03/02/2019","$50000.-","Respaldo"});
        model.addRow(new Object[]{"N° 05236","12/03/2019","$30000.-","Inversion"});
        model.addRow(new Object[]{"N° 87452","26/06/2019","$76000.-","Actualizacion"});
        model.addRow(new Object[]{"N° 45123","16/09/2019","$10000.-","Respaldo"});
        model.addRow(new Object[]{"N° 88542","25/11/2019","$23000.-","Respaldo"});
        model.addRow(new Object[]{"N° 12543","03/01/2020","$46800.-","Respaldo"});
        model.addRow(new Object[]{"N° 15469","16/06/2020","$12000.-","Respaldo"});

        table1.setModel(model);




        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
