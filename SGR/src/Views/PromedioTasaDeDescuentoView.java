package Views;

import Controllers.*;
import Models.*;
import Models.Enums.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class PromedioTasaDeDescuentoView extends JDialog{
    private JComboBox cmbTipoEmpresa;
    private JTextField txtFechaFinal;
    private JTextField txtFechaInicial;
    private JTable table1;
    private JButton salirButton;
    private JPanel pnlPrincipal;
    private JButton buscarButton;
    private JPanel pnlTabla;
    private SocioController SocioController;

    public PromedioTasaDeDescuentoView(Window owner, SocioController SocioController) {
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
        this.SocioController = SocioController;
    }
    private void asociarEventos(){
        salirButton.addActionListener(e -> dispose());

        buscarButton.addActionListener(e -> {
            var tipoEmpresa = TipoEmpresa.valueOf(cmbTipoEmpresa.getSelectedItem().toString());
            Date fechaInicial = new Date(txtFechaInicial.getText());
            Date fechaFinal = new Date(txtFechaFinal.getText());
            ArrayList<SocioModel> socios = SocioController.getSocios();
            var promedioTasaDescuento = new ArrayList<promedioTasaDeDescuento>();
            for(SocioModel socio:socios){
                if (socio.getTipoEmpresa() == tipoEmpresa){
                    ArrayList<LineaCreditoModel> lineaCreditos = socio.getLineaCreditos();
                    for(LineaCreditoModel lineaCredito:lineaCreditos){
                        ArrayList<ChequeModel> cheques = lineaCredito.getCheques();
                        for(ChequeModel cheque:cheques){
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
        });
    }
}
