package Views;

import Controllers.*;
import Models.*;

import javax.swing.*;
import java.awt.*;

public class AporteView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtDinero;
    private JLabel lblSocio;

    private SocioController socioController;
    private SocioModel socio;

    public AporteView(Window owner, String cuit) {
        super(owner);
        //De esa forma le digo que el pnlPrincipal es el primero que se va a iniciar y le va a dar el contenido a mi pantalla.
        this.setContentPane(contentPane);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        asociarEventos();
        this.setTitle("Nuevo aporte");

        socioController = SocioController.getInstance();

        socio = socioController.getSociosByCuit(cuit);

        lblSocio.setText("Socio: " + cuit);
    }

    private void asociarEventos() {
        buttonOK.addActionListener(e -> {
            try{
                socio.addAporte(new AporteModel(Long.parseLong(txtDinero.getText())));
                JOptionPane.showMessageDialog(null, "Nuevo aporte agregado!");
                dispose();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });

        buttonCancel.addActionListener(e -> dispose());
    }
}
