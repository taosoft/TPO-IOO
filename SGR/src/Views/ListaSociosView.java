package Views;

import Controllers.*;
import Models.*;

import javax.swing.*;
import java.awt.*;

public class ListaSociosView extends JDialog {
    private JPanel pnlPrincipal;
    private JButton convertirEnSocioPlenoButton;
    private JButton agregarAporteButton;
    private JButton verLíneaDeCréditoButton;
    private JButton generarOperaciónButton;
    private JButton riesgoVivoButton;
    private JButton cerrarButton;
    private JPanel pnlListarSocios;
    private JComboBox cmbCuitSocio;
    private JButton altaNuevoSocioButton;
    private ListaSociosView self;
    private SocioController socioController;

    public ListaSociosView(Window owner) {
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

        for (SocioModel socio: socioController.getSocios()) {
            cmbCuitSocio.addItem(socio.getCuit());
        };

        if (cmbCuitSocio.getItemCount() <= 0){
            convertirEnSocioPlenoButton.setEnabled(false);
            agregarAporteButton.setEnabled(false);
            verLíneaDeCréditoButton.setEnabled(false);
            //generarOperaciónButton.setEnabled(false);
            riesgoVivoButton.setEnabled(false);
        }

        /*generarOperaciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmOperaciones frame = new FrmOperaciones(self);
                frame.setVisible(true);

            }
        });*/
        
        verLíneaDeCréditoButton.addActionListener(e -> {
            LineasCreditoView frame = new LineasCreditoView(self, cmbCuitSocio.getSelectedItem().toString());
            frame.show();
        });
        altaNuevoSocioButton.addActionListener(e -> {
            AltaNuevoSocioView frame = new AltaNuevoSocioView(self);
            frame.show();
        });
    }

    private void asociarEventos() {
        cerrarButton.addActionListener(e -> dispose());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}