package Views;

import Controllers.*;
import Models.*;
import Models.Enums.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OperacionesView extends JDialog {
    private JButton chequesButton;
    private JButton prestamosButton;
    private JButton CCComercialesButton;
    private JTable tablaOperaciones;
    private JButton cerrarButton;
    private JPanel pnlOperaciones;
    private JPanel pnlOperac;
    private JButton emitirCertificadoButton;
    private final OperacionesView self;
    DefaultTableModel model;
    private final String cuit;

    private final SgrController sgrController;
    private final UsuarioController usuarioController;
    private final LineaCreditoModel lineaCredito;

    public OperacionesView(Window owner, String cuit, int idLineaCredito) {
        super(owner);
        this.setContentPane(pnlOperaciones);
        this.setSize(500, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        //No permite volver a la pantalla anterior hasta cerrar esta.
        this.setModal(true);
        asociarEventos();
        this.self = this;

        SocioController socioController = SocioController.getInstance();
        sgrController = SgrController.getInstance();
        usuarioController = UsuarioController.getInstance();

        lineaCredito = socioController.getSociosByCuit(cuit).getLineaCreditosById(idLineaCredito);

        this.cuit = cuit;

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Operacion");
        model.addColumn("Importe");
        model.addColumn("Fecha Acreditada");
        model.addColumn("Fecha Vencimiento");
        model.addColumn("Estado");

        LoadOperaciones();
        tablaOperaciones.addComponentListener(new ComponentAdapter() {
        });
    }

    private void asociarEventos() {
        cerrarButton.addActionListener(e -> dispose());

        chequesButton.addActionListener(e -> {
            ChequeView frame = new ChequeView(self, cuit, lineaCredito.getId());
            frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    LoadOperaciones();
                }
            });
        });

        CCComercialesButton.addActionListener(e -> {
            CuentasCorrienteView frame = new CuentasCorrienteView(self, cuit, lineaCredito.getId());
            frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    LoadOperaciones();
                }
            });
        });

        prestamosButton.addActionListener(e -> {
            PrestamoView frame = new PrestamoView(self, cuit, lineaCredito.getId());
            frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    LoadOperaciones();
                }
            });
        });

        emitirCertificadoButton.addActionListener(e -> {
            try{
                var idOperacion = Integer.parseInt(
                        tablaOperaciones.getModel().getValueAt(tablaOperaciones.getSelectedRow(),
                                0).toString());

                var tipoOperacion = TipoOperacion.valueOf(
                        tablaOperaciones.getModel().getValueAt(tablaOperaciones.getSelectedRow(),
                                1).toString());

                switch (tipoOperacion) {
                    case ChequePropio -> {
                        var chequePropio = lineaCredito.getChequeById(idOperacion);
                        sgrController.addLogOperacionModel(new LogOperacionModel(chequePropio.getEstadoOperacion(),
                                EstadoOperacion.ConCertificadoEmitido, chequePropio.getId(),
                                usuarioController.GetUsuarioLoggueado().getNombre()));
                        chequePropio.setEstadoOperacion(EstadoOperacion.ConCertificadoEmitido);
                        chequePropio.setCertificadoGarantia(new CertificadoGarantiaModel());
                    }
                    case CCComercial -> {
                        var cuentaCorriente = lineaCredito.getCuentaCorrienteById(idOperacion);
                        sgrController.addLogOperacionModel(new LogOperacionModel(cuentaCorriente.getEstadoOperacion(),
                                EstadoOperacion.ConCertificadoEmitido, cuentaCorriente.getId(),
                                usuarioController.GetUsuarioLoggueado().getNombre()));
                        cuentaCorriente.setEstadoOperacion(EstadoOperacion.ConCertificadoEmitido);
                        cuentaCorriente.setCertificadoGarantia(new CertificadoGarantiaModel());
                    }
                    case Prestamo -> {
                        var prestamo = lineaCredito.getPrestamoById(idOperacion);
                        sgrController.addLogOperacionModel(new LogOperacionModel(prestamo.getEstadoOperacion(),
                                EstadoOperacion.ConCertificadoEmitido, prestamo.getId(),
                                usuarioController.GetUsuarioLoggueado().getNombre()));
                        prestamo.setEstadoOperacion(EstadoOperacion.ConCertificadoEmitido);
                        prestamo.setCertificadoGarantia(new CertificadoGarantiaModel());
                    }
                }

                LoadOperaciones();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });
    }

    private void LoadOperaciones() {
        BorrarRows();

        for(PrestamoModel prestamo: lineaCredito.getPrestamos()){
            model.addRow(new Object[]{
                    prestamo.getId(),
                    prestamo.getTipo(), prestamo.getImportePagado(), prestamo.getFecha(),
                    prestamo.getFechaVencimiento(), prestamo.getEstadoOperacion()});
        }

        for(ChequeModel cheque: lineaCredito.getCheques()){
            model.addRow(new Object[]{
                    cheque.getId(),
                    cheque.getTipo(), cheque.getImportePagado(), cheque.getFecha(),
                    cheque.getFechaVencimiento(), cheque.getEstadoOperacion()});
        }

        for(CuentaCorrienteModel cuentaCorriente: lineaCredito.getCuentaCorrientes()){
            model.addRow(new Object[]{
                    cuentaCorriente.getId(),
                    cuentaCorriente.getTipo(), cuentaCorriente.getImportePagado(), cuentaCorriente.getFecha(),
                    cuentaCorriente.getFechaVencimiento(), cuentaCorriente.getEstadoOperacion()});
        }

        tablaOperaciones.setModel(model);
    }

    private void BorrarRows(){
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
    }
}
