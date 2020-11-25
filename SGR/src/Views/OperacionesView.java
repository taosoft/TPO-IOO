package Views;

import Controllers.*;
import Models.*;
import Models.Enums.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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
    private JButton recepcionDeDineroDeButton;
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
        this.setTitle("Operaciones");

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
                    case ChequePropio -> administrarCambioEstadoOperacion(lineaCredito.getChequeById(idOperacion));
                    case CCComercial -> administrarCambioEstadoOperacion(lineaCredito.getCuentaCorrienteById(idOperacion));
                    case Prestamo -> administrarCambioEstadoOperacion(lineaCredito.getPrestamoById(idOperacion));
                }

                LoadOperaciones();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        });

        tablaOperaciones.getSelectionModel().addListSelectionListener(e -> {
            try{
                if(tablaOperaciones.getSelectedRow() == -1){
                    return;
                }

                var idOperacion = Integer.parseInt(tablaOperaciones.getModel()
                        .getValueAt(tablaOperaciones.getSelectedRow(),
                        0).toString());

                var tipoOperacion = TipoOperacion.valueOf(
                        tablaOperaciones.getModel().getValueAt(tablaOperaciones.getSelectedRow(),
                                1).toString());

                switch (tipoOperacion) {
                    case ChequePropio, ChequeTerceros -> {
                        OperacionModel operacion = lineaCredito.getChequeById(idOperacion);
                        recepcionDeDineroDeButton.setVisible(operacion.getEstadoOperacion() == EstadoOperacion.ConCertificadoEmitido);
                        adminsitrarVisibilidadBotonCertificadoGarantia(operacion);
                    }
                    case CCComercial -> {
                        OperacionModel operacion = lineaCredito.getCuentaCorrienteById(idOperacion);
                        adminsitrarVisibilidadBotonCertificadoGarantia(operacion);
                    }
                    case Prestamo -> {
                        OperacionModel operacion = lineaCredito.getPrestamoById(idOperacion);
                        adminsitrarVisibilidadBotonCertificadoGarantia(operacion);
                    }
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Select changed: " + ex.getMessage());
            }
        });

        recepcionDeDineroDeButton.addActionListener(e -> {
            try{
                var idOperacion = Integer.parseInt(
                        tablaOperaciones.getModel().getValueAt(tablaOperaciones.getSelectedRow(),
                                0).toString());

                var tipoOperacion = TipoOperacion.valueOf(
                        tablaOperaciones.getModel().getValueAt(tablaOperaciones.getSelectedRow(),
                                1).toString());

                switch (tipoOperacion) {
                    case ChequePropio, ChequeTerceros -> {
                        OperacionModel operacion = lineaCredito.getChequeById(idOperacion);
                        sgrController.addLogOperacionModel(new LogOperacionModel(operacion.getEstadoOperacion(),
                                EstadoOperacion.Monetizado, operacion.getId(),
                                usuarioController.GetUsuarioLoggueado().getNombre()));
                        operacion.setEstadoOperacion(EstadoOperacion.Monetizado);
                        operacion.setCertificadoGarantia(new CertificadoGarantiaModel());
                        operacion.setComision(new ComisionModel());

                        JOptionPane.showMessageDialog(null, "Dinero de operacion recibido!");
                    }
                }

                LoadOperaciones();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,
                        "Recepcion de dinero de operacion" + ex.getMessage());
            }
        });
    }

    private void administrarCambioEstadoOperacion(OperacionModel operacion) {
        if(lineaCredito.superaLinea(operacion.getImportePagado())){
            JOptionPane.showMessageDialog(null, "Supera el límite de la linea de crédito");
        }
        else{
            sgrController.addLogOperacionModel(new LogOperacionModel(operacion.getEstadoOperacion(),
                    EstadoOperacion.ConCertificadoEmitido, operacion.getId(),
                    usuarioController.GetUsuarioLoggueado().getNombre()));
            operacion.setEstadoOperacion(EstadoOperacion.ConCertificadoEmitido);
            operacion.setCertificadoGarantia(new CertificadoGarantiaModel());

            JOptionPane.showMessageDialog(null, "Certificado de garantía emitido!");
        }
    }

    private void adminsitrarVisibilidadBotonCertificadoGarantia(OperacionModel operacion){
        emitirCertificadoButton.setVisible(operacion.getEstadoOperacion() == EstadoOperacion.Ingresado);
    }

    private void LoadOperaciones() {
        emitirCertificadoButton.setVisible(false);
        recepcionDeDineroDeButton.setVisible(false);
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
