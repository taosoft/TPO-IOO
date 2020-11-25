package Views;

import Controllers.SocioController;
import Models.*;
import Models.Enums.TipoSistema;
import Models.Enums.TipoSocio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class PrestamoView extends JDialog {
    private JPanel ifrmPrestamo;
    private JTextField txtBanco;
    private JTextField txtImporte;
    private JTextField txtTasa;
    private JTextField txtFechaAcreditacion;
    private JTextField txtCantidadCuotas;
    private JButton confirmarButton;
    private JButton cancelarButton;
    private JComboBox cmbTipoSistema;
    private SocioController socioController;
    private LineaCreditoModel lineaCredito;

    public PrestamoView(Window owner, String cuit, int idLineaCredito) {
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
        asociarEventos();

        socioController = SocioController.getInstance();
        lineaCredito = socioController.getSociosByCuit(cuit).getLineaCreditosById(idLineaCredito);
    }

    private void asociarEventos() {
        cancelarButton.addActionListener(e -> dispose());

        confirmarButton.addActionListener(e -> {
            try{
                lineaCredito.addPrestamo(PrestamoModel.CrearNuevoPrestamo(txtBanco.getText(),
                        Float.parseFloat(txtTasa.getText()), Integer.parseInt(txtCantidadCuotas.getText()),
                        TipoSistema.valueOf(cmbTipoSistema.getSelectedItem().toString()),
                        Integer.parseInt(txtImporte.getText()), new Date(txtFechaAcreditacion.getText())));

                dispose();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage() +  "Datos incorrectos/faltantes");
            }
        });
    }
}