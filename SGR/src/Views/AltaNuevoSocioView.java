package Views;

import Controllers.*;
import Models.*;
import Models.Enums.*;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class AltaNuevoSocioView extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox cmbTipoSocio;
    private JTextField txtCuit;
    private JTextField txtRazonSocial;
    private JTextField txtFiniAct;
    private JComboBox cmbTipoEmpresa;
    private JTextField txtActividad;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCorreoElectronico;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private SocioController socioController;
    private UsuarioController usuarioController;

    public AltaNuevoSocioView(Window owner) {
        super(owner);
        //De esa forma le digo que el pnlPrincipal es el primero que se va a iniciar y le va a dar el contenido a mi pantalla.
        this.setContentPane(pnlPrincipal);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        this.asociarEventos();

        socioController = SocioController.getInstance();
        usuarioController = UsuarioController.getInstance();

        aceptarButton.addActionListener(e -> {
            socioController.AddSocio(SocioModel.CrearSocio(usuarioController.GetUsuarioLoggueado().getNombre(),
                    txtCuit.getText(),txtRazonSocial.getText(),
                    TipoEmpresa.valueOf(cmbTipoEmpresa.getSelectedItem().toString()),
                    txtActividad.getText(),txtDireccion.getText(),
                    txtTelefono.getText(),txtCorreoElectronico.getText(),new Date(txtFiniAct.getText()),
                    TipoSocio.valueOf(cmbTipoSocio.getSelectedItem().toString())));

            dispose();
        });
    }

    private void asociarEventos(){
        cancelarButton.addActionListener(e -> dispose());
    }
}
