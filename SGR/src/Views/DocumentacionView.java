package Views;

import Controllers.*;
import Models.Enums.EstadoDocumento;
import Models.Enums.TipoDocumento;
import Models.LogDocumentoSocioModel;
import Models.LogEstadoDocumentoSocioModel;
import Models.SocioModel;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Objects;

public class DocumentacionView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cmbTipoDocumento;
    private JComboBox cmbEstadoDocumento;
    private DocumentacionView self;
    private SocioController socioController;
    private SgrController sgrController;
    private UsuarioController usuarioController;
    private SocioModel socio;

    public DocumentacionView(Window owner, String cuit) {
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
        this.asociarEventos();
        this.self = this;

        socioController = SocioController.getInstance();
        sgrController = SgrController.getInstance();
        usuarioController = UsuarioController.getInstance();

        socio = socioController.getSociosByCuit(cuit);
        cmbEstadoDocumento.setSelectedItem(socio.getEstadoDocumento().toString());
        cmbTipoDocumento.setSelectedItem(socio.getTipoDocumento().toString());
    }

    private void asociarEventos() {
        buttonCancel.addActionListener(e -> dispose());

        buttonOK.addActionListener(e -> {

            var tipoDocumentoView =
                    TipoDocumento.valueOf(Objects.requireNonNull(cmbTipoDocumento.getSelectedItem().toString()));

            var estadoDocumentoView =
                    EstadoDocumento.valueOf(Objects.requireNonNull(cmbEstadoDocumento.getSelectedItem().toString()));

            if(tipoDocumentoView != socio.getTipoDocumento()){
                sgrController.addLogDocumentoSocioModel(LogDocumentoSocioModel.CrearLogDocumentoSocioModel(new Date(),
                        socio.getTipoDocumento(),
                        tipoDocumentoView,
                        usuarioController.GetUsuarioLoggueado().getNombre()));
            }

            if(estadoDocumentoView != socio.getEstadoDocumento()){
                sgrController.addLogEstadoDocumentoSocioModel(
                        LogEstadoDocumentoSocioModel.CrearLogEstadoDocumentoSocioModel(new Date(),
                            socio.getEstadoDocumento(),
                            estadoDocumentoView,
                            usuarioController.GetUsuarioLoggueado().getNombre()));
            }

            dispose();
        });
    }
}
