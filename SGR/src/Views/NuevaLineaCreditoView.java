package Views;

import javax.swing.*;

public class NuevaLineaCreditoView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public NuevaLineaCreditoView() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        asociarEventos();
    }

    private void asociarEventos() {
        buttonOK.addActionListener(e -> {

        });

        buttonCancel.addActionListener(e -> dispose());
    }
}
