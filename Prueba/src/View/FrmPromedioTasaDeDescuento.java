package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPromedioTasaDeDescuento extends JDialog{
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTable table1;
    private JButton salirButton;
    private JPanel pnlPrincipal;

    public FrmPromedioTasaDeDescuento(Window owner) {
        super(owner);
        //De esa forma le digo que el pnlPrincipal es el primero que se va a iniciar y le va a dar el contenido a mi pantalla.
        this.setContentPane(pnlPrincipal);
        this.setSize(650, 450);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        this.asociarEventos();

    }
    private void asociarEventos(){
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {dispose();}
        });
    }
}
