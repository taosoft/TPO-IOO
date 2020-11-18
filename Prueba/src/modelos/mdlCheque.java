package modelos;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Date;

public class mdlCheque {
    private String bancoEmisor;
    private String numeroCheque;
    private Date fechaVencimiento;
    private String cuitFirmante;





=======
public class mdlCheque extends mdlOperacion{
    private int importePagado;

    public void importeAPagar(int _importePagado){
        importePagado = _importePagado;
    }

    public int getImportePagado(){
        return importePagado;
    }
>>>>>>> 5206146fe39d474a51188f524259573b56601f45
}
