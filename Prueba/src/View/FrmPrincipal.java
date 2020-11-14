package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPrincipal extends JFrame{
    private JPanel pnlPrincipal;
    private JButton altaNuevoSocioButton;
    private JButton listarSociosButton;
    private JButton totalComisionesCalculadasButton;
    private JButton operacionesAvaladasANombreButton;
    private JButton valorPromedioDeTasaButton;
    private JButton consultaConsolidadaButton;
    private JButton porcentajeComisiónAUnButton;
    private FrmPrincipal self;


    public FrmPrincipal(String titulo) {
            super(titulo);
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


    }
    private void asociarEventos(){
        altaNuevoSocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAltaNuevoSocio frame = new FrmAltaNuevoSocio(self);
                frame.setVisible(true);
            }
        });

        listarSociosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmListaSocios frame = new FrmListaSocios(self);
                frame.setVisible(true);
            }
        });

        totalComisionesCalculadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmComisionesCalculadas frame = new FrmComisionesCalculadas(self);
                frame.setVisible(true);
            }
        });

        operacionesAvaladasANombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmOperacionesAvaladasNombre frame = new FrmOperacionesAvaladasNombre(self);
                frame.setVisible(true);

            }
        });

        valorPromedioDeTasaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmPromedioTasaDeDescuento frame = new FrmPromedioTasaDeDescuento(self);
                frame.setVisible(true);
            }
        });
        consultaConsolidadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmConsultasConsolidadas frame = new FrmConsultasConsolidadas(self);
                frame.setVisible(true);

            }
        });
        porcentajeComisiónAUnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmPorcentajeComisionSocio frame = new FrmPorcentajeComisionSocio(self);
                frame.setVisible(true);
            }
        });
    }

        public static void main(String[] args) {
            FrmPrincipal frame = new FrmPrincipal("Programa SGR");
            frame.setVisible(true);
        }
    }

