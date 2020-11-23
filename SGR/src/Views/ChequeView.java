package Views;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

import Controllers.*;
import Models.*;

public class ChequeView extends JDialog {
    private JTextField txtBancoEmisor;
    private JTextField txtNumeroCheque;
    private JTextField txtFechaVencimiento;
    private JTextField txtCuitFirmante;
    private JButton cerrarButton;
    private JButton confirmarButton;
    private JPanel pnlCheque;
    private JTextField txtImporte;
    private SocioController socioController;
    private LineaCreditoModel lineaCredito;

    public ChequeView(Window owner, String cuit, int idLineaCredito) {
        super(owner);
        this.setContentPane(pnlCheque);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        asociarEventos();

        socioController = SocioController.getInstance();
        lineaCredito = socioController.getSociosByCuit(cuit).getLineaCreditosById(idLineaCredito);
    }

    private void asociarEventos() {
        cerrarButton.addActionListener(e -> dispose());

        confirmarButton.addActionListener(e -> {
            try{
                lineaCredito.addCheque(ChequeModel.crearNuevoCheque(txtBancoEmisor.getText(), txtNumeroCheque.getText(),
                        new Date(txtFechaVencimiento.getText()), txtCuitFirmante.getText(),
                        Integer.parseInt(txtImporte.getText())));

                dispose();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });
    }
}
