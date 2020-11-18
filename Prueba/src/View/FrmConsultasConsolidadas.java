package View;

import controllers.ctrSGR;
import controllers.ctrSocio;
import modelos.estadoSocio;
import modelos.mdlSocio;
import modelos.tipoDocumento;
import modelos.tipoSocio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class FrmConsultasConsolidadas extends JDialog {
    private JPanel pnlPrincipal;
    private JTable table1;
    private JComboBox comboBox1;
    private JButton buscarButton;
    private JButton salirButton;
    private FrmConsultasConsolidadas self;

    public FrmConsultasConsolidadas(Window owner, ctrSocio ctrSocio, ctrSGR ctrSgr) {
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

        this.self = this;
        /*String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
        comboBox1 = new JComboBox(petStrings);
        comboBox1.setModel();*/
        ArrayList<mdlSocio> socios = obtenerListaSoscios();

        for (mdlSocio socio:ctrSocio.getSocios()) {
            comboBox1.addItem(socio.getCuit());
        };


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalRiesgoVivo = ctrSgr.getConsolidadas("");


              /*  DefaultTableModel model = new DefaultTableModel();

                model.addColumn("Socios");
                model.addColumn("Riesgo Vivo");
                model.addColumn("Total Reutilizado");

                model.addRow(new Object[]{"1","Computadora","$ 5000"});
                model.addRow(new Object[]{"2","Computadora","$ 7000"});
                model.addRow(new Object[]{"3","Computadora","$ 4000"});
                model.addRow(new Object[]{"4","Computadora","$ 1000"});
                model.addRow(new Object[]{"5","Computadora","$ 500"});
                model.addRow(new Object[]{"6","Computadora","$ 2000"});

                table1.setModel(model);*/

            }
        });
    }

    private ArrayList<mdlSocio> obtenerListaSoscios(){

        ctrSocio ctrSocio = new ctrSocio();
        var socio = mdlSocio.CrearSocio("Mario","30715645579","Empresa S.A.","Comunidad de bienes",
                "comercialización", "libertadores 123","353535","dasd@sadas.com",
                new Date(), tipoSocio.Participe);

        ctrSocio.AddSocio((socio));

        mdlSocio.CrearSocio("Juan","30801032158","Luz S.A.","Comunidad de bienes",
                "comercialización", "Chacabuco 123","353535","dasd@sadas.com",
                new Date(), tipoSocio.Participe);

        ctrSocio.AddSocio((socio));

        return ctrSocio.getSocios();
    }


    private void asociarEventos(){
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
    }

}
