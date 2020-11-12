package Views;

import javax.swing.*;
import java.awt.event.*;

public class vtnPorcentajeComisionSocio extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JButton buscarButton;
    private JRadioButton tipo1RadioButton;
    private JRadioButton tipo2RadioButton;
    private JRadioButton tipo3RadioButton;
    private JComboBox comboBox1;
    private JList listaPorcentajeComisionSocio;

    public vtnPorcentajeComisionSocio() {
        setContentPane(contentPane);
        setModal(true);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        vtnPorcentajeComisionSocio dialog = new vtnPorcentajeComisionSocio();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
