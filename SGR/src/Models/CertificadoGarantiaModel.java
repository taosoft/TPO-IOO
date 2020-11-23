package Models;

import java.util.concurrent.ThreadLocalRandom;

public class CertificadoGarantiaModel {
    private long numero;

    public CertificadoGarantiaModel(){
        numero = ThreadLocalRandom.current().nextLong(Integer.MAX_VALUE);
    }

    public static CertificadoGarantiaModel CrearCertificadoGarantia(long _numero){
        var certificadoGarantia = new CertificadoGarantiaModel();
        certificadoGarantia.numero = _numero;

        return certificadoGarantia;
    }

    public long getNumero(){
        return numero;
    }
}
