package Views;

import Controllers.*;
import Models.*;
import javax.swing.*;

public class FrmPrincipal extends JFrame{
    private JPanel pnlPrincipal;
    private JButton altaNuevoSocioButton;
    private JButton listarSociosButton;
    private JButton totalComisionesCalculadasButton;
    private JButton operacionesAvaladasANombreButton;
    private JButton valorPromedioDeTasaButton;
    private JButton consultaConsolidadaButton;
    private JButton porcentajeComisiónAUnButton;
    private JTextField txtUsuario;
    private JTextField txtPassword;
    private JButton btnIngresar;
    private JPanel pnlLogin;
    private JPanel pnlSocios;
    private JPanel pnlConsultasGenerales;
    private JButton btnCerrar;
    private FrmPrincipal self;
    private SocioController SocioController;
    private mdlUsuario usuarioLogueado;

    private UsuarioController UsuarioController;

    public FrmPrincipal(String titulo) {
            super(titulo);

            SocioController = new SocioController();
            UsuarioController = new UsuarioController();

            pnlSocios.setVisible(false);
            pnlConsultasGenerales.setVisible(false);
            pnlLogin.setVisible(true);

            //Esto de abajo es para cambiar la forma en que se ven los botones y la ventana para que se parezca más al formato windows.
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (UnsupportedLookAndFeelException e) {
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


        btnIngresar.addActionListener(e -> {

        mdlUsuario usuario = new mdlUsuario(txtUsuario.getText(),txtPassword.getText());

            if(UsuarioController.esUsuario(usuario)) {
                pnlLogin.setVisible(false);
                pnlSocios.setVisible(true);
                pnlConsultasGenerales.setVisible(true);
                usuarioLogueado = usuario;
            }

            else {
                pnlSocios.setVisible(false);
                pnlConsultasGenerales.setVisible(false);
                pnlLogin.setVisible(true);
                JOptionPane.showMessageDialog(null,"El usuario/password es incorrecto");
            }
        });

        btnCerrar.addActionListener(e -> dispose());
    }

    private void asociarEventos(){
        altaNuevoSocioButton.addActionListener(e -> {
            AltaNuevoSocioView frame = new AltaNuevoSocioView(self, SocioController,usuarioLogueado.getNombre());
            frame.setVisible(true);
        });

        listarSociosButton.addActionListener(e -> {
            ListaSociosView frame = new ListaSociosView(self, SocioController);
            frame.setVisible(true);
        });

        totalComisionesCalculadasButton.addActionListener(e -> {
            ComisionesCalculadasView frame = new ComisionesCalculadasView(self, SocioController);
            frame.setVisible(true);
        });

        operacionesAvaladasANombreButton.addActionListener(e -> {
            FrmOperacionesAvaladasNombre frame = new FrmOperacionesAvaladasNombre(self, SocioController);
            frame.setVisible(true);

        });

        valorPromedioDeTasaButton.addActionListener(e -> {
            FrmPromedioTasaDeDescuento frame = new FrmPromedioTasaDeDescuento(self, SocioController);
            frame.setVisible(true);
        });
        consultaConsolidadaButton.addActionListener(e -> {

            ConsultasConsolidadasView frame = new ConsultasConsolidadasView(self, SocioController,new SgrController());
            frame.setVisible(true);

        });
        /*porcentajeComisiónAUnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                *//*FrmPorcentajeComisionSocio frame = new FrmPorcentajeComisionSocio(self);
                frame.setVisible(true);*//*
            }
        });*/
    }

        public static void main(String[] args) {
            FrmPrincipal frame = new FrmPrincipal("Programa SGR");
            frame.setVisible(true);
        }
    }
