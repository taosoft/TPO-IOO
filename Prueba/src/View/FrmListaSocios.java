package View;

import controllers.ctrSocio;
import modelos.mdlSocio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmListaSocios extends JDialog {
    private JPanel pnlPrincipal;
    private JButton convertirEnSocioPlenoButton;
    private JButton agregarAporteButton;
    private JButton verLíneaDeCréditoButton;
    private JButton generarOperaciónButton;
    private JButton riesgoVivoButton;
    private JButton cerrarButton;
    private JPanel pnlListarSocios;
    private JComboBox cmbCuitSocio;
    private FrmListaSocios self;

    public FrmListaSocios(Window owner, ctrSocio ctrSocio) {
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

        for (mdlSocio socio:ctrSocio.getSocios()) {
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
        
        verLíneaDeCréditoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmLineaCredito frame = new frmLineaCredito(self, ctrSocio);
                frame.show();
            }
        });
    }

    private void asociarEventos() {
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {dispose();}
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
