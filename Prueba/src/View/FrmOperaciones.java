package View;

import modelos.mdlLineaCredito;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrmOperaciones extends JDialog {
    private JButton chequesButton;
    private JButton prestamosButton;
    private JButton CCComercialesButton;
    private JTable table1;
    private JButton cerrarButton;
    private JButton aceptarButton;
    private JPanel pnlOperaciones;
    private JPanel pnlOperac;
    private ifrmPrestamo self;


    public FrmOperaciones(Window owner) {
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
        model.addColumn("Operaciones");
        model.addColumn("Tipo");
        model.addColumn("Fecha");
        model.addColumn("Estado");

        model.addRow(new Object[]{"Deposito","Inversion","05/04/2020","Imputada"});
        model.addRow(new Object[]{"Deposito","Inversion","07/05/2020","Imputada"});
        model.addRow(new Object[]{"Deposito","Inversion","04/06/2020","Imputada"});
        model.addRow(new Object[]{"Deposito","Capitalizacion","25/08/2020","Pendiente"});


        table1.setModel(model);


        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        chequesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ifrmCheque frame = new ifrmCheque(self, new mdlLineaCredito());
                frame.setVisible(true);
            }
        });
        CCComercialesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ifrmCuentasCorrientes frame = new ifrmCuentasCorrientes(self);
                frame.show();
            }
        });

        prestamosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ifrmPrestamo frame = new ifrmPrestamo(self);
                frame.setVisible(true);
            }
        });
    }
}
