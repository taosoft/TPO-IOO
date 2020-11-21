package View;




import controllers.ctrSocio;
import modelos.mdlPrestamo;
import modelos.tipoSistema;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ifrmPrestamo extends JDialog {
    private JPanel ifrmPrestamo;
    private JTextField txtBanco;
    private JTextField txtImporteTotal;
    private JTextField txtTasa;
    private JTextField txtFechaAcreditacion;
    private JTextField txtCantidadCuotas;
    private JButton confirmarButton;
    private JButton cancelarButton;
    private JComboBox cmbTipoSistema;
    private ifrmPrestamo self;

//<<<<<<< Updated upstream
    public ifrmPrestamo(Window owner, ArrayList<mdlPrestamo> prestamos) {
//=======
   // public ifrmPrestamo(Window owner, ctrSocio ctrSocio, String nombreUsuario) {
//>>>>>>> Stashed changes

        super(owner);
        this.setContentPane(ifrmPrestamo);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        //this.self = this;
        this.asociarEventos();


        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrSocio.AddPrestamo(mdlPrestamo.CrearPrestamo(nombreUsuario,txtBanco.getText(),txtImporteTotal.getText(),
                        txtTasa.getText(),txtFechaAcreditacion.getText(),txtCantidadCuotas.getText(),
                        tipoSistema.valueOf(cmbTipoSistema.getSelectedItem().toString(),dispose();)));
            }
        });

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // aca agrego los datos
               mdlPrestamo prestamo = new mdlPrestamo();
               prestamos.add(prestamo);
               dispose();
            }
        });
    }
    private void asociarEventos(){
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {dispose();}
        });
    }

}