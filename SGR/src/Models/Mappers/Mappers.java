package Models.Mappers;

import Models.Enums.NumeracionTipoOperacion;

import java.util.EnumMap;

public class Mappers {
    public static EnumMap<NumeracionTipoOperacion, Integer> GetMapEnumOperacionComision() {

        EnumMap<NumeracionTipoOperacion, Integer> mapper = new EnumMap<>(NumeracionTipoOperacion.class);

        mapper.put(NumeracionTipoOperacion.uno, 3);
        mapper.put(NumeracionTipoOperacion.dos, 3);
        mapper.put(NumeracionTipoOperacion.tres, 4);

        return mapper;
    }
}
