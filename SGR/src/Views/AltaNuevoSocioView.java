package Views;

import Controllers.*;
import Models.*;
import Models.Enums.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
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
    private JTable tablaAccionistas;
    private JTextField txtCuitAccionista;
    private JTextField txtRazonSocialAccionista;
    private JTextField txtPorcentajeAccionista;
    private JButton agregarAccionistaButton;
    private SocioController socioController;
    private UsuarioController usuarioController;
    private ArrayList<AccionistaModel> accionistasTemporal;
    private DefaultTableModel model;

    public AltaNuevoSocioView(Window owner) {
        super(owner);
        //De esa forma le digo que el pnlPrincipal es el primero que se va a iniciar y le va a dar el contenido a mi pantalla.
        this.setContentPane(pnlPrincipal);
        this.setSize(500, 500);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        this.asociarEventos();
        this.setTitle("Alta de nuevo socio");

        socioController = SocioController.getInstance();
        usuarioController = UsuarioController.getInstance();

        accionistasTemporal = new ArrayList<>();

        model = new DefaultTableModel();
        model.addColumn("Cuit");
        model.addColumn("Razon social");
        model.addColumn("Porcentaje");

        tablaAccionistas.setModel(model);
    }

    private void asociarEventos(){
        cancelarButton.addActionListener(e -> dispose());

        agregarAccionistaButton.addActionListener(e -> {
            try{
                var accionista = AccionistaModel.CrearNuevoAccionista(txtCuitAccionista.getText(),
                        txtRazonSocialAccionista.getText(), Float.parseFloat(txtPorcentajeAccionista.getText()));

                accionistasTemporal.add(accionista);

                model.addRow(new Object[]{accionista.getCuit(), accionista.getRazonSocial(),
                        accionista.getPorcentajeParticipacion()});

                tablaAccionistas.setModel(model);

                txtCuitAccionista.setText("");
                txtRazonSocialAccionista.setText("");
                txtPorcentajeAccionista.setText("");
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        aceptarButton.addActionListener(e -> {
            try{
                var nuevoSocio = SocioModel.CrearSocio(usuarioController.GetUsuarioLoggueado().getNombre(),
                        txtCuit.getText(),txtRazonSocial.getText(),
                        TipoEmpresa.valueOf(cmbTipoEmpresa.getSelectedItem().toString()),
                        txtActividad.getText(),txtDireccion.getText(),
                        txtTelefono.getText(),txtCorreoElectronico.getText(),new Date(txtFiniAct.getText()),
                        TipoSocio.valueOf(cmbTipoSocio.getSelectedItem().toString()));

                nuevoSocio.setAccionistas(accionistasTemporal);

                socioController.AddSocio(nuevoSocio);

                dispose();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
    }
}
