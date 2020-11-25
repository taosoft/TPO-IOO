package Views;

import Controllers.*;
import Models.Enums.*;
import Models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Objects;

public class SociosView extends JDialog {
    private JPanel pnlPrincipal;
    private JPanel pnlBotones;
    private JButton convertirEnSocioPlenoButton;
    private JButton agregarAporteButton;
    private JButton verLineaDeCreditoButton;
    private JButton cerrarButton;
    private JPanel pnlListarSocios;
    private JComboBox cmbCuitSocio;
    private JButton altaNuevoSocioButton;
    private JButton documentacionButton;
    private JLabel txtEstadoSocio;
    private JTable tablaAportes;
    private final SociosView self;
    private final SocioController socioController;
    private final SgrController sgrController;
    private final UsuarioController usuarioController;
    private DefaultTableModel model;

    public SociosView(Window owner) {
        super(owner);
        //De esa forma le digo que el pnlPrincipal es el primero que se va a iniciar y le va a dar el contenido a mi pantalla.
        this.setContentPane(pnlListarSocios);
        this.setSize(700, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        this.asociarEventos();
        this.self = this;
        this.setTitle("Socios");

        socioController = SocioController.getInstance();
        sgrController = SgrController.getInstance();
        usuarioController = UsuarioController.getInstance();

        LoadSocios();

        model = new DefaultTableModel();
        model.addColumn("Fecha");
        model.addColumn("Importe");
        tablaAportes.setModel(model);
        LoadTabla();
    }

    private void LoadTabla() {
        BorrarRows();
        try{
            var socio = socioController.getSociosByCuit(cmbCuitSocio.getSelectedItem().toString());

            for(AporteModel aporte : socio.getAportes()){
                model.addRow(new Object[]{
                        aporte.getFecha(), aporte.getDinero()});
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }

        tablaAportes.setModel(model);
    }

    private void LoadSocios() {
        cmbCuitSocio.removeAllItems();

        convertirEnSocioPlenoButton.setVisible(false);
        agregarAporteButton.setEnabled(false);
        documentacionButton.setEnabled(false);
        verLineaDeCreditoButton.setEnabled(false);

        for (SocioModel socio: socioController.getSocios()) {
            cmbCuitSocio.addItem(socio.getCuit());
        };
    }

    private void BorrarRows(){
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
    }

    private void asociarEventos() {
        cerrarButton.addActionListener(e -> dispose());

        agregarAporteButton.addActionListener(e -> {
            AporteView frame = new AporteView(self,
                    Objects.requireNonNull(cmbCuitSocio.getSelectedItem()).toString());

            frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    LoadTabla();
                }
            });
        });

        documentacionButton.addActionListener(e -> {
            DocumentacionView frame = new DocumentacionView(self,
                    Objects.requireNonNull(cmbCuitSocio.getSelectedItem()).toString());
            frame.setVisible(true);

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    LoadSocios();
                }
            });
        });

        verLineaDeCreditoButton.addActionListener(e -> {
            LineasCreditoView frame = new LineasCreditoView(self,
                    Objects.requireNonNull(cmbCuitSocio.getSelectedItem()).toString());
            frame.setVisible(true);
        });

        altaNuevoSocioButton.addActionListener(e -> {
            AltaNuevoSocioView frame = new AltaNuevoSocioView(self);
            frame.setVisible(true);

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    LoadSocios();
                }
            });
        });

        cmbCuitSocio.addActionListener(e -> {
            var socio = getSocio();

            if(socio == null){
                agregarAporteButton.setEnabled(false);
                documentacionButton.setEnabled(false);
                verLineaDeCreditoButton.setEnabled(false);
                convertirEnSocioPlenoButton.setVisible(false);
                txtEstadoSocio.setText("");

                return;
            }

            convertirEnSocioPlenoButton.setVisible(socio.getEstadoSocio() == EstadoSocio.Postulante &&
                    socio.getEstadoDocumento() == EstadoDocumento.Controlado);

            txtEstadoSocio.setText("Estado Socio: " + socio.getEstadoSocio());

            agregarAporteButton.setEnabled(true);
            documentacionButton.setEnabled(true);
            verLineaDeCreditoButton.setEnabled(true);
        });

        convertirEnSocioPlenoButton.addActionListener(e -> {
            try{
                var socio = getSocio();

                if(socio == null)
                    return;

                sgrController.addLogEstadoSocioModel(LogEstadoSocioModel.CrearNuevoLogEstadoSocioModel(new Date(),
                        socio.getEstadoSocio(), EstadoSocio.Pleno,
                        usuarioController.GetUsuarioLoggueado().getNombre()));

                socio.setEstadoSocio(EstadoSocio.Pleno);

                JOptionPane.showMessageDialog(null,"Socio " + socio.getCuit() +
                        " convertido a socio pleno");

                txtEstadoSocio.setText("Estado Socio: " + socio.getEstadoSocio());

                convertirEnSocioPlenoButton.setVisible(false);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });
    }

    private SocioModel getSocio(){
        if(cmbCuitSocio.getSelectedItem() == null){
            return null;
        }
        return socioController.getSociosByCuit(Objects.requireNonNull(cmbCuitSocio.getSelectedItem().toString()));
    }
}