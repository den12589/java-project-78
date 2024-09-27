package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<String, String>> {

    public MapSchema sizeOf(int size) {
        addToChecks("isSizeOf", m -> m == null || m.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        addToChecks("isValidateMap", givenMap -> givenMap == null || schemas.entrySet()
                .stream()
                .allMatch(pair -> pair.getValue().isValid(givenMap.get(pair.getKey()))));
        return this;
    }

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }
}
