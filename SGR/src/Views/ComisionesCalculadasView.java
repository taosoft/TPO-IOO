package Views;

import Controllers.*;
import Models.*;
import Models.ViewModels.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class ComisionesCalculadasView extends JDialog{
    private JButton salirButton;
    private JTable tablaComisiones;
    private JTextField txtFecha;
    private JPanel pnlPrincipal;
    private JButton buscarButton;
    private SocioController socioController;
    private DefaultTableModel model;

    public ComisionesCalculadasView(Window owner) {
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
        this.asociarEventos();
        this.setTitle("Total comisiones calculadas");

        socioController = SocioController.getInstance();

        model = new DefaultTableModel();
        model.addColumn("Porcentaje comision");
        model.addColumn("Total comision");
        model.addColumn("Numero de cheque");
        tablaComisiones.setModel(model);
    }

    private void BorrarRows(){
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
    }

    private void asociarEventos(){
        salirButton.addActionListener(e -> dispose());

        buscarButton.addActionListener(e -> {
            try{
                var socios = socioController.getSocios();
                var comisionesCalculadas = new ArrayList<ComisionCalculadaViewModel>();
                for(SocioModel socio: socios){
                    var lineasCredito = socio.getLineaCreditos();

                    for(LineaCreditoModel lineaCredito:lineasCredito){
                        var cheques = lineaCredito.getCheques();

                        for (ChequeModel cheque: cheques) {
                            if(cheque.getFecha().compareTo(new Date(txtFecha.getText())) == 0){
                                comisionesCalculadas.add(new ComisionCalculadaViewModel(cheque.getTasaDeDescuento(),
                                        cheque.getNumeroCheque(), cheque.getImportePagado()));
                            }
                        }
                    }
                }

                BorrarRows();
                for(ComisionCalculadaViewModel comisionCalculada: comisionesCalculadas){
                    model.addColumn(comisionCalculada);
                }
                tablaComisiones.setModel(model);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog (null, ex.getMessage() + "No se encontraron resultados para su busqueda");
            }
        });
    }
}
