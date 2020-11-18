package View;

import controllers.ctrSocio;
import modelos.mdlSocio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmOperacionesAvaladasNombre extends JDialog {
    private JPanel pnlPrincipal;
    private JButton cerrarButton;
    private JTable table1;
    private JTextField txtDesde;
    private JTextField txtHasta;
    private JComboBox comboBox1;
    private JButton buscarButton;

    public FrmOperacionesAvaladasNombre(Window owner, ctrSocio ctrSocio) {
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

        for (mdlSocio socio:ctrSocio.getSocios()) {
            comboBox1.addItem(socio.getCuit());
        };


        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                DefaultTableModel model = new DefaultTableModel();

                model.addColumn("Cuit Socio");
                model.addColumn("Razon Social");
                model.addColumn("Tipo");


                for(mdlSocio socio:ctrSocio.getSocios()){

                    model.addRow(new Object[]{socio.getCuit(),socio.getRazonSocial(),socio.getTipoSocio()});

                }

                table1.setModel(model);



            }
        });
    }

    private void asociarEventos()

    {
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {dispose();}
        });
    }
}
