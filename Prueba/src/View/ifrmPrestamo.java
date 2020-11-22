package View;

import modelos.mdlPrestamo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ifrmPrestamo extends JDialog {
    private JPanel ifrmPrestamo;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton confirmarButton;
    private JButton cancelarButton;
    private ifrmPrestamo self;

    public ifrmPrestamo(Window owner, ArrayList<mdlPrestamo> prestamos) {

        super(owner);
        this.setContentPane(ifrmPrestamo);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        //this.self = this;


        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // aca agrego los datos
               mdlPrestamo prestamo = new mdlPrestamo();
               prestamos.add(prestamo);
               dispose();
            }
        });
    }

}