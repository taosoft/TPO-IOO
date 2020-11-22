package Views;

import Controllers.*;
import Models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class FrmComisionesCalculadas extends JDialog{
    private JButton salirButton;
    private JTable tablaComisiones;
    private JTextField txtFecha;
    private JPanel pnlPrincipal;
    private JButton buscarButton;
    private DefaultTableModel model;

    public FrmComisionesCalculadas(Window owner, SocioController SocioController) {
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

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Porcentaje comision");
        model.addColumn("Total comision");
        model.addColumn("Numero de cheque");
        tablaComisiones.setModel(model);


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var socios = SocioController.getSocios();
                var comisionesCalculadas = new ArrayList<comisionesCalculadas>();
                for(mdlSocio socio: socios){
                    var lineasCredito = socio.getLineaCreditos();

                    for(mdlLineaCredito lineaCredito:lineasCredito){
                        var cheques = lineaCredito.getCheques();

                        for (mdlCheque cheque: cheques) {
                            if(cheque.getFecha().compareTo(new Date(txtFecha.getText())) == 0){
                                comisionesCalculadas.add(new comisionesCalculadas(cheque.getTasaDeDescuento(),
                                        cheque.getNumeroCheque(), cheque.getImportePagado()));
                            }
                        }
                    }
                }

                tablaComisiones.removeAll();
                model.addColumn("Porcentaje comision");
                model.addColumn("Total comision");
                model.addColumn("Numero de cheque");
                for(comisionesCalculadas comisionCalculada: comisionesCalculadas){
                    model.addColumn(comisionCalculada);
                }
                tablaComisiones.setModel(model);
            }
        });
    }
    private void asociarEventos(){
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });

    }
}
