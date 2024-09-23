package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {

    public void sizeof(int size) {
        checks.put("isSizeOf", m -> m.size() == size);
    }

    public void shape(Map<String, BaseSchema<String>> schemas) {
        checks.put("isValidateMap", map -> schemas.entrySet()
                .stream()
                .allMatch(pair -> pair.getValue().isValid(map.get(pair.getKey()))));
    }
}
