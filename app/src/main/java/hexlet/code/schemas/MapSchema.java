package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {

    public void sizeof(int size) {
        checks.add(m -> m.size() == size);
    }

    public boolean shape(Map<String, BaseSchema<String>> schemas) {
        return true;
    }
}
