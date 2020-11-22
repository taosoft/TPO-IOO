package Views;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

import Models.*;

public class ifrmCheque extends JDialog {
    private JTextField txtBancoEmisor;
    private JTextField txtNumeroCheque;
    private JTextField txtFechaVencimiento;
    private JTextField txtCuitFirmante;
    private JButton cerrarButton;
    private JButton confirmarButton;
    private JPanel pnlCheque;

    public ifrmCheque(Window owner, mdlLineaCredito mdlLineaCredito) {

        super(owner);
        this.setContentPane(pnlCheque);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);

        cerrarButton.addActionListener(e -> dispose());

        confirmarButton.addActionListener(e -> {
            mdlLineaCredito.addCheque(mdlCheque.crearNuevoCheque(txtBancoEmisor.getText(), txtNumeroCheque.getText(),
                    new Date(txtFechaVencimiento.getText()), txtCuitFirmante.getText()));

            dispose();
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
