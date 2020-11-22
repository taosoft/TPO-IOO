package Views;

import javax.swing.*;
import java.awt.*;

public class CuentasCorrienteView extends JDialog{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton cerrarButton;
    private JButton confirmarButton;
    private JPanel pnlCuentasCorrientes;
    private CuentasCorrienteView self;

    public CuentasCorrienteView(Window owner) {

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

        cerrarButton.addActionListener(e -> dispose());
    }
}
