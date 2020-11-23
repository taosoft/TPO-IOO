package Views;

import Controllers.*;
import Models.Enums.*;
import Models.*;

import javax.swing.*;
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
    private JButton riesgoVivoButton;
    private JButton cerrarButton;
    private JPanel pnlListarSocios;
    private JComboBox cmbCuitSocio;
    private JButton altaNuevoSocioButton;
    private JButton documentacionButton;
    private final SociosView self;
    private final SocioController socioController;
    private final SgrController sgrController;
    private final UsuarioController usuarioController;

    public SociosView(Window owner) {
        super(owner);
        //De esa forma le digo que el pnlPrincipal es el primero que se va a iniciar y le va a dar el contenido a mi pantalla.
        this.setContentPane(pnlListarSocios);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        this.asociarEventos();
        this.self = this;

        socioController = SocioController.getInstance();
        sgrController = SgrController.getInstance();
        usuarioController = UsuarioController.getInstance();

        LoadSocios();
    }

    private void LoadSocios() {
        cmbCuitSocio.removeAllItems();

        convertirEnSocioPlenoButton.setVisible(false);
        agregarAporteButton.setEnabled(false);
        documentacionButton.setEnabled(false);
        verLineaDeCreditoButton.setEnabled(false);
        riesgoVivoButton.setEnabled(false);

        for (SocioModel socio: socioController.getSocios()) {
            cmbCuitSocio.addItem(socio.getCuit());
        };
    }

    private void asociarEventos() {
        cerrarButton.addActionListener(e -> dispose());

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

            convertirEnSocioPlenoButton.setVisible(socio.getEstadoSocio() == EstadoSocio.Postulante &&
                    socio.getEstadoDocumento() == EstadoDocumento.Controlado);

            agregarAporteButton.setEnabled(true);
            documentacionButton.setEnabled(true);
            verLineaDeCreditoButton.setEnabled(true);
            riesgoVivoButton.setEnabled(true);
        });

        convertirEnSocioPlenoButton.addActionListener(e -> {
            sgrController.addLogEstadoSocioModel(LogEstadoSocioModel.CrearNuevoLogEstadoSocioModel(new Date(),
                    getSocio().getEstadoSocio(), EstadoSocio.Pleno,
                    usuarioController.GetUsuarioLoggueado().getNombre()));

            getSocio().setEstadoSocio(EstadoSocio.Pleno);
        });
    }

    private SocioModel getSocio(){
        return socioController.getSociosByCuit(Objects.requireNonNull(cmbCuitSocio.getSelectedItem()).toString());
    }
}