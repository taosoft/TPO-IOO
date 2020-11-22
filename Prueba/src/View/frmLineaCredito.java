package View;

import controllers.ctrSocio;
import modelos.mdlLineaCredito;
import modelos.mdlSocio;
import modelos.mdlTipoOperacion;
import modelos.tipoOperacion;

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
    private JButton agregarButton;
    private frmLineaCredito self;

<<<<<<< HEAD
    public frmLineaCredito(Window owner, ctrSocio ctrSocio) {
=======

    public frmLineaCredito(Window owner, mdlSocio socio) {
>>>>>>> 250206968b18e341e146595df89a6cd850b0c531
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


            lblCliente.setText(socio.getCuit());

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Tipo operaciones");
        model.addColumn("Monto");
<<<<<<< HEAD
        model.addColumn("Tipo operacion");

        for(mdlSocio socio:ctrSocio.getSocios()){
            model.addRow(new Object[]{socio.getRazonSocial(),socio.getLineaCreditos(),
                    socio.getFechaInicioActividades(),socio.getAportes(),socio.getTipoSocio()});
=======
        model.addColumn("Fecha");

        for(mdlLineaCredito lineaCredito: socio.getLineaCreditos()){
            String tipoOperacionesConcat = new String();
            for(tipoOperacion tipoOperacion: lineaCredito.getTipoOperaciones()){
                tipoOperacionesConcat += tipoOperacion.toString();
            }
            model.addRow(new Object[]{tipoOperacionesConcat,lineaCredito.getMonto(), lineaCredito.getFechaVigencia(), lineaCredito.getId()});
>>>>>>> 250206968b18e341e146595df89a6cd850b0c531
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
                //Integer.parseInt(table1.getModel().getValueAt(table1.getSelectedRow(),4).toString()
                var lineaCredito = socio.getLineaCreditosById(1);
                FrmOperaciones frame = new FrmOperaciones(self, lineaCredito);
                frame.setVisible(true);
            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
