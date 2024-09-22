package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {

    public void sizeof(int size) {
        checks.add(m -> m.size() == size);
    }
}
