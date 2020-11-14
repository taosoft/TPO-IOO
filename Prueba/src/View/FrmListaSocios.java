package View;

import javax.swing.*;
import java.awt.*;

public class FrmListaSocios extends JDialog{
    private JPanel pnlPrincipal;
    private JTextField textField1;
    private JButton convertirEnSocioPlenoButton;
    private JButton agregarAporteButton;
    private JButton verLíneaDeCréditoButton;
    private JButton generarOperaciónButton;
    private JButton riesgoVivoButton;
    private JButton cerrarButton;

    public FrmListaSocios(Window owner) {
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
    }
}
