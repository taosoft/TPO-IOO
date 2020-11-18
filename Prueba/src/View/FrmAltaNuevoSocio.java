
package View;

import controllers.ctrSocio;
import modelos.mdlSocio;
import modelos.tipoEmpresa;
import modelos.tipoSocio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FrmAltaNuevoSocio extends JDialog {
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
    private String nombreUsuario;

    public FrmAltaNuevoSocio(Window owner, ctrSocio ctrSocio, String nombreUsuario) {
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
        this.nombreUsuario = nombreUsuario;



        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrSocio.AddSocio(mdlSocio.CrearSocio(nombreUsuario,txtCuit.getText(),txtRazonSocial.getText(),
                tipoEmpresa.valueOf(cmbTipoEmpresa.getSelectedItem().toString()),txtActividad.getText(),txtDireccion.getText(),
                txtTelefono.getText(),txtCorreoElectronico.getText(),new Date(txtFiniAct.getText()), tipoSocio.valueOf(cmbTipoSocio.getSelectedItem().toString()),null));
                dispose();

            }
        });



    }
    private void asociarEventos(){
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {dispose();}
        });
    }
}
