package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<String, String>> {

    public MapSchema sizeof(int size) {
        checks.put("isSizeOf", m -> m == null || m.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        checks.put("isValidateMap", givenMap -> givenMap == null || schemas.entrySet()
                .stream()
                .allMatch(pair -> pair.getValue().isValid(givenMap.get(pair.getKey()))));
        return this;
    }

    @Override
    public MapSchema required() {
        checks.put("NonNull", Objects::nonNull);
        return this;
    }
}
