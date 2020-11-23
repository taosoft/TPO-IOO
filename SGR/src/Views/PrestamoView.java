package Views;

import Models.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PrestamoView extends JDialog {
    private JPanel ifrmPrestamo;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton confirmarButton;
    private JButton cancelarButton;
    private PrestamoView self;

    public PrestamoView(Window owner, ArrayList<PrestamoModel> prestamos) {

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
        this.setTitle("Prestamos");

        cancelarButton.addActionListener(e -> dispose());

        confirmarButton.addActionListener(e -> {
           // aca agrego los datos
           PrestamoModel prestamo = new PrestamoModel();
           prestamos.add(prestamo);
           dispose();
        });
    }

}