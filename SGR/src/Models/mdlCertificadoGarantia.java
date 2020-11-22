package Models;

public class mdlCertificadoGarantia {
    private long numero;

    public static mdlCertificadoGarantia crearCertificadoGarantia(long _numero){
        var certificadoGarantia = new mdlCertificadoGarantia();
        certificadoGarantia.numero = _numero;

        return certificadoGarantia;
    }

    public long getNumero(){
        return numero;
    }
}
