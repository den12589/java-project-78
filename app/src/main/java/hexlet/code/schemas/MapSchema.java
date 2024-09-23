package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {

    public MapSchema sizeof(int size) {
        checks.put("isSizeOf", m -> m.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        checks.put("isValidateMap", givenMap -> schemas.entrySet()
                .stream()
                .allMatch(pair -> pair.getValue().isValid(givenMap.get(pair.getKey()))));
        return this;
    }
}
