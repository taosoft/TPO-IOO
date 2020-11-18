package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ifrmCuentasCorrientes extends JDialog{
    private JTextField txtEmpresa;
    private JTextField txtImporteTotal;
    private JTextField txtFechaVencimiento;
    private JButton cerrarButton;
    private JButton confirmarButton;
    private JPanel pnlCuentasCorrientes;
    private ifrmCuentasCorrientes self;

    public ifrmCuentasCorrientes(Window owner) {

        super(owner);
        this.setContentPane(pnlCuentasCorrientes);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        //this.self = this;


        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });


    }
}
