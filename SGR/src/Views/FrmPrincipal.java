package Views;
import javax.swing.*;

public class FrmPrincipal extends JFrame {

    private JPanel pnlPrincipal;
    private JButton button2;
    private JButton button1;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button3;
    private JButton button7;
    private FrmPrincipal self;

    public FrmPrincipal(String titulo) {
        super(titulo);
        //Esto de abajo es para cambiar la forma en que se ven los botones y la ventana para que se parezca más al formato windows.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        //De esa forma le digo que el pnlPrincipal es el primero que se va a iniciar y le va a dar el contenido a mi pantalla.
        this.setContentPane(pnlPrincipal);
        this.setSize(400, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        FrmPrincipal frame = new FrmPrincipal("Programa SGR");
        frame.setVisible(true);
    }
}
