package Views;

import Controllers.*;
import Models.*;
import Models.Enums.*;
import Models.ViewModels.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class PromedioTasaDeDescuentoView extends JDialog{
    private JComboBox cmbTipoEmpresa;
    private JTextField txtFechaFinal;
    private JTextField txtFechaInicial;
    private JTable table1;
    private JButton salirButton;
    private JPanel pnlPrincipal;
    private JButton buscarButton;
    private JPanel pnlTabla;
    private SocioController socioController;
    private DefaultTableModel model;

    public PromedioTasaDeDescuentoView(Window owner) {
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
        this.setTitle("Valor promedio de tasa de descuento");

        this.socioController =  Controllers.SocioController.getInstance();

        model = new DefaultTableModel();
        model.addColumn("Cuit Socio");
        model.addColumn("Promedio tasa de descuento");
        model.addColumn("Total operado en cheques");
        model.addColumn("Total operado en pagarés");
        table1.setModel(model);
    }

    private void asociarEventos(){
        salirButton.addActionListener(e -> dispose());

        buscarButton.addActionListener(e -> {
            try {
                var tipoEmpresa = TipoEmpresa.valueOf(Objects.requireNonNull(cmbTipoEmpresa.getSelectedItem()).toString());
                Date fechaInicial = new Date(txtFechaInicial.getText());
                Date fechaFinal = new Date(txtFechaFinal.getText());
                ArrayList<SocioModel> socios = socioController.getSocios();
                var promedioTasaDescuento = new ArrayList<PromedioTasaDeDescuentoViewModel>();
                /*for (SocioModel socio : socios) {
                    if (socio.getTipoEmpresa() == tipoEmpresa) {
                        ArrayList<LineaCreditoModel> lineaCreditos = socio.getLineaCreditos();
                        for (LineaCreditoModel lineaCredito : lineaCreditos) {
                            ArrayList<ChequeModel> cheques = lineaCredito.getCheques();
                            for (ChequeModel cheque : cheques) {
                                if (cheque.getFecha().after(fechaInicial) && cheque.getFecha().before(fechaFinal)) {
                                    var mdlPromeidoTasaDeDescuento = new PromedioTasaDeDescuentoViewModel();
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

                for(var promedio : promedioTasaDescuento){
                    model.addRow(new Object[]{promedio.getNombreSocio(), promedio.getPromedio(),
                            promedio.getTotalOperado(), promedio.getTotalOperado()});
                }*/

                table1.setModel(model);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() + " - No se encontraron resultados para su busqueda");
            }
        });
    }
}
