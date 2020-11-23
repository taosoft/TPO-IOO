package Models;

import java.util.Date;

public class AporteModel {
    private Date fecha;
    private long dinero;

    public AporteModel(long dinero) {
        this.fecha = new Date();
        this.dinero = dinero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getDinero() {
        return dinero;
    }

    public void setDinero(long dinero) {
        this.dinero = dinero;
    }
}
