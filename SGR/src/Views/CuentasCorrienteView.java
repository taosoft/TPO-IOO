package Views;

import Controllers.*;
import Models.*;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class CuentasCorrienteView extends JDialog{
    private JTextField txtEmpresa;
    private JTextField txtImporte;
    private JTextField txtFechaVencimiento;
    private JButton cerrarButton;
    private JButton guardarNuevaCuentaCorrienteButton;
    private JPanel pnlCuentasCorrientes;
    private SocioController socioController;
    private LineaCreditoModel lineaCredito;

    public CuentasCorrienteView(Window owner, String cuit, int idLineaCredito) {
        super(owner);
        this.setContentPane(pnlCuentasCorrientes);
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

        guardarNuevaCuentaCorrienteButton.addActionListener(e -> {
            try{
                lineaCredito.addCuentaCorriente(CuentaCorrienteModel.CrearNuevaCuentaCorriente(txtEmpresa.getText(),
                        new Date(txtFechaVencimiento.getText()), Integer.parseInt(txtImporte.getText())));

                dispose();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });
    }
}
