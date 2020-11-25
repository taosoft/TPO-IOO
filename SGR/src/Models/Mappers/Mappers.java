package Models.Mappers;

import Models.Enums.NumeracionTipoOperacion;
import Models.Enums.TipoOperacion;

import java.util.EnumMap;

public class Mappers {
    public static EnumMap<NumeracionTipoOperacion, Integer> GetMapEnumOperacionComision() {

        EnumMap<NumeracionTipoOperacion, Integer> mapper = new EnumMap<>(NumeracionTipoOperacion.class);

        mapper.put(NumeracionTipoOperacion.uno, 3);
        mapper.put(NumeracionTipoOperacion.dos, 3);
        mapper.put(NumeracionTipoOperacion.tres, 4);

        return mapper;
    }

    public static EnumMap<TipoOperacion, NumeracionTipoOperacion> GetMapEnumTipoOperacionOperacion() {

        EnumMap<TipoOperacion, NumeracionTipoOperacion> mapper = new EnumMap<>(TipoOperacion.class);

        mapper.put(TipoOperacion.ChequePropio, NumeracionTipoOperacion.uno);
        mapper.put(TipoOperacion.ChequeTerceros, NumeracionTipoOperacion.uno);
        mapper.put(TipoOperacion.PagareBursatil, NumeracionTipoOperacion.uno);
        mapper.put(TipoOperacion.CCComercial, NumeracionTipoOperacion.dos);
        mapper.put(TipoOperacion.TarjetaCredito, NumeracionTipoOperacion.dos);
        mapper.put(TipoOperacion.Prestamo, NumeracionTipoOperacion.tres);

        return mapper;
    }
}
