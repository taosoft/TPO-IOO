package View;

import controllers.ctrSocio;
import modelos.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class FrmPromedioTasaDeDescuento extends JDialog{
    private JComboBox cmbTipoEmpresa;
    private JTextField txtFechaFinal;
    private JTextField txtFechaInicial;
    private JTable table1;
    private JButton salirButton;
    private JPanel pnlPrincipal;
    private JButton buscarButton;
    private JPanel pnlTabla;
    private ctrSocio ctrSocio;

    public FrmPromedioTasaDeDescuento(Window owner, ctrSocio ctrSocio) {
        super(owner);
        //De esa forma le digo que el pnlPrincipal es el primero que se va a iniciar y le va a dar el contenido a mi pantalla.
        this.setContentPane(pnlPrincipal);
        this.setSize(650, 450);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        this.asociarEventos();
        this.ctrSocio = ctrSocio;


    }
    private void asociarEventos(){
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {dispose();}
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tipoEmpresa tipoEmpresa = modelos.tipoEmpresa.valueOf(cmbTipoEmpresa.getSelectedItem().toString());
                Date fechaInicial = new Date(txtFechaInicial.getText());
                Date fechaFinal = new Date(txtFechaFinal.getText());
                ArrayList<mdlSocio> socios = ctrSocio.getSocios();
                var promedioTasaDescuento = new ArrayList<promedioTasaDeDescuento>();
                for(mdlSocio socio:socios){
                    if (socio.getTipoEmpresa() == tipoEmpresa){
                        ArrayList<mdlLineaCredito> lineaCreditos = socio.getLineaCreditos();
                        for(mdlLineaCredito lineaCredito:lineaCreditos){
                            ArrayList<mdlCheque> cheques = lineaCredito.getCheques();
                            for(mdlCheque cheque:cheques){
                                if(cheque.getFecha().after(fechaInicial)&& cheque.getFecha().before(fechaFinal)){
                                    var mdlPromeidoTasaDeDescuento = new promedioTasaDeDescuento();
                                    mdlPromeidoTasaDeDescuento.setNombreSocio(socio.getCuit());
                                    mdlPromeidoTasaDeDescuento.setTotalOperado(mdlPromeidoTasaDeDescuento.getTotalOperado() + cheque.getImportePagado());
                                    mdlPromeidoTasaDeDescuento.setTasaDescuento(mdlPromeidoTasaDeDescuento.getTasaDescuento() + cheque.getTasaDeDescuento());
                                    mdlPromeidoTasaDeDescuento.setCantidad(mdlPromeidoTasaDeDescuento.getCantidad() + 1);
                                    promedioTasaDescuento.add(mdlPromeidoTasaDeDescuento);
                                }
                            }
                        }
                    }
                }
                DefaultTableModel tablaModelo = new DefaultTableModel();
                tablaModelo.addColumn("tasa de descuento");
                tablaModelo.addColumn("total operado de cheques");
                tablaModelo.addColumn("total operado de pagares");

                tablaModelo.addRow(new Object[]{"1","Computadora","$ 5000"});
                table1.setModel(tablaModelo);
            }
        });
    }
}