package View;

import javax.swing.*;
import java.awt.*;

public class FrmPorcentajeComisionSocio extends JDialog{
    private JPanel pnlPrincipal;
    private JComboBox comboBox1;
    private JRadioButton tipo1RadioButton;
    private JRadioButton tipo2RadioButton;
    private JRadioButton tipo3RadioButton;
    private JTable table1;
    private JButton cerrarButton;
    private JButton buscarButton;

    public FrmPorcentajeComisionSocio(Window owner) {
        super(owner);
        //De esa forma le digo que el pnlPrincipal es el primero que se va a iniciar y le va a dar el contenido a mi pantalla.
        this.setContentPane(pnlPrincipal);
        this.setSize(550, 450);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
    }
}
