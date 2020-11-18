package View;

import modelos.mdlSocio;
import modelos.tipoSocio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ifrmCheque extends JDialog {
    private JTextField txtBancoEmisor;
    private JTextField txtNumeroCheque;
    private JTextField txtFechaVencimiento;
    private JTextField txtCuitFirmante;
    private JButton cerrarButton;
    private JButton confirmarButton;
    private JPanel pnlCheque;
    private ifrmCheque self;

    public ifrmCheque(Window owner) {

        super(owner);
        this.setContentPane(pnlCheque);
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
