package Models;

public class CertificadoGarantiaModel {
    private long numero;

    public static CertificadoGarantiaModel crearCertificadoGarantia(long _numero){
        var certificadoGarantia = new CertificadoGarantiaModel();
        certificadoGarantia.numero = _numero;

        return certificadoGarantia;
    }

    public long getNumero(){
        return numero;
    }
}
