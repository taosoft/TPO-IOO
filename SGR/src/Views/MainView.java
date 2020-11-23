package Views;

import Controllers.*;
import Models.*;
import javax.swing.*;

public class MainView extends JFrame {
    private JPanel pnlPrincipal;
    private JButton listarSociosButton;
    private JButton totalComisionesCalculadasButton;
    private JButton operacionesAvaladasANombreButton;
    private JButton valorPromedioDeTasaButton;
    private JButton consultaConsolidadaButton;
    private JTextField txtUsuario;
    private JTextField txtPassword;
    private JButton btnIngresar;
    private JPanel pnlLogin;
    private JPanel pnlSocios;
    private JPanel pnlConsultasGenerales;
    private JButton btnCerrar;
    private MainView self;
    private SocioController SocioController;

    private UsuarioController usuarioController;

    public MainView(String titulo) {
        super(titulo);

        SocioController = SocioController.getInstance();
        usuarioController = UsuarioController.getInstance();

        pnlSocios.setVisible(false);
        pnlConsultasGenerales.setVisible(false);
        pnlLogin.setVisible(true);

        //Esto de abajo es para cambiar la forma en que se ven los botones y la ventana para que se parezca más al formato windows.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        //De esa forma le digo que el pnlPrincipal es el primero que se va a iniciar y le va a dar el contenido a mi pantalla.
        this.setContentPane(pnlPrincipal);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.asociarEventos();
        this.self = this;
    }

    private void asociarEventos(){
        btnIngresar.addActionListener(e -> {

            UsuarioModel usuario = new UsuarioModel(txtUsuario.getText(),txtPassword.getText());

            if(usuarioController.esUsuario(usuario)) {
                pnlLogin.setVisible(false);
                pnlSocios.setVisible(true);
                pnlConsultasGenerales.setVisible(true);
                usuarioController.LoggearUsuario(usuario);
            }

            else {
                pnlSocios.setVisible(false);
                pnlConsultasGenerales.setVisible(false);
                pnlLogin.setVisible(true);
                JOptionPane.showMessageDialog(null,"El usuario/password es incorrecto");
                usuarioController.DesloggearUsuario();
            }
        });

        btnCerrar.addActionListener(e -> dispose());

        listarSociosButton.addActionListener(e -> {
            SociosView frame = new SociosView(self);
            frame.setVisible(true);
        });

        totalComisionesCalculadasButton.addActionListener(e -> {
            ComisionesCalculadasView frame = new ComisionesCalculadasView(self);
            frame.setVisible(true);
        });

        operacionesAvaladasANombreButton.addActionListener(e -> {
            OperacionesAvaladasNombreView frame = new OperacionesAvaladasNombreView(self);
            frame.setVisible(true);
        });

        valorPromedioDeTasaButton.addActionListener(e -> {
            PromedioTasaDeDescuentoView frame = new PromedioTasaDeDescuentoView(self);
            frame.setVisible(true);
        });

        consultaConsolidadaButton.addActionListener(e -> {
            ConsultasConsolidadasView frame = new ConsultasConsolidadasView(self);
            frame.setVisible(true);
        });
    }

    public static void main(String[] args) {
        MainView frame = new MainView("Sistema SGR");
        frame.setVisible(true);
    }
}
