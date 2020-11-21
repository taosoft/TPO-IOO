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
    private JButton operarButton;
    private frmLineaCredito self;


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
        this.self = this;

        for (mdlSocio socio:ctrSocio.getSocios()) {
            lblCliente.setText(socio.getCuit());
        };

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Socio");
        model.addColumn("Linea de credito");
        model.addColumn("Fecha");
        model.addColumn("Monto");
        model.addColumn("Tipo operacion");

        for(mdlSocio socio:ctrSocio.getSocios()){

            model.addRow(new Object[]{socio.getRazonSocial(),socio.getLineaCreditos(),socio.getFechaInicioActividades(),socio.getAportes(),socio.getTipoSocio()});

        }

        table1.setModel(model);




        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        operarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmOperaciones frame = new FrmOperaciones(self);
                frame.setVisible(true);
            }
        });
    }
}
