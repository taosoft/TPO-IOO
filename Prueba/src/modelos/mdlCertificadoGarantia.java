package modelos;

public class mdlCertificadoGarantia {
    private long numero;

    public static void crearCertificadoGarantia(long _numero){
        var certificadoGarantia = new mdlCertificadoGarantia();
        certificadoGarantia.numero = _numero;
    }

    public long getNumero(){
        return numero;
    }
}
