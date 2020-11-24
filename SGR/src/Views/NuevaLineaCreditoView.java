package Views;

import Controllers.SocioController;
import Models.Enums.TipoOperacion;
import Models.LineaCreditoModel;
import Models.SocioModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class NuevaLineaCreditoView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtFechaVigencia;
    private JTextField txtMonto;
    private JCheckBox chChequePropio;
    private JCheckBox chChequeTerceros;
    private JCheckBox chPrestamo;
    private JCheckBox chPagareBursatil;
    private JCheckBox chCCComercial;
    private JCheckBox chTarjetaCredito;

    private SocioController socioController;
    private SocioModel socio;

    public NuevaLineaCreditoView(Window owner, String cuit) {
        super(owner);
        this.setContentPane(contentPane);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        this.setTitle("Nueva línea crédito");

        asociarEventos();

        socioController = SocioController.getInstance();

        socio = socioController.getSociosByCuit(cuit);
    }

    private void asociarEventos() {
        buttonOK.addActionListener(e -> {
            try{
                var fechaVigencia = new Date(txtFechaVigencia.getText());
                var monto = Long.parseLong(txtMonto.getText());

                var listaTipoOperaciones = new ArrayList< TipoOperacion >();

                if(chCCComercial.isSelected()){
                    listaTipoOperaciones.add(TipoOperacion.CCComercial);
                }
                if(chChequeTerceros.isSelected()){
                    listaTipoOperaciones.add(TipoOperacion.ChequeTerceros);
                }
                if(chPagareBursatil.isSelected()){
                    listaTipoOperaciones.add(TipoOperacion.PagareBursatil);
                }
                if(chPrestamo.isSelected()){
                    listaTipoOperaciones.add(TipoOperacion.Prestamo);
                }
                if(chTarjetaCredito.isSelected()){
                    listaTipoOperaciones.add(TipoOperacion.TarjetaCredito);
                }
                if(chChequePropio.isSelected()){
                    listaTipoOperaciones.add(TipoOperacion.ChequePropio);
                }

                var nuevaLineaCredito = LineaCreditoModel.CrearLineaCredito(fechaVigencia, monto,
                        listaTipoOperaciones);

                socio.addLineaCredito(nuevaLineaCredito);
                dispose();
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null,"Datos incorrectos/faltantes");
            }
        });

        buttonCancel.addActionListener(e -> dispose());
    }
}
