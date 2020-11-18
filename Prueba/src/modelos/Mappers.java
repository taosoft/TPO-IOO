package modelos;

import java.util.EnumMap;

public class Mappers {
    public static EnumMap<numeracionTipoOperacion, Integer> GetMapEnumOperacionComision() {

        EnumMap<numeracionTipoOperacion, Integer> mapper = new EnumMap<>(numeracionTipoOperacion.class);

        mapper.put(numeracionTipoOperacion.uno, 3);
        mapper.put(numeracionTipoOperacion.dos, 3);
        mapper.put(numeracionTipoOperacion.tres, 4);

        return mapper;
    }
}
