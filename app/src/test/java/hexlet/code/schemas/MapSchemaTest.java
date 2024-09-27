package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {

    private MapSchema schema;

    @BeforeEach
    void setup() {
        schema = new Validator().map();
    }

    @Test
    void required() {
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(Map.of()));
    }

    @Test
    void sizeof() {
        assertTrue(schema.isValid(Map.of("key", "value")));
        schema.sizeof(2);
        assertFalse(schema.isValid(Map.of("key", "value")));
        assertTrue(schema.isValid(Map.of("key1", "value1", "key2", "value2")));
        assertFalse(schema.isValid(Map.of("key1", "value1", "key2", "value2", "key3", "value3")));
    }

    @Test
    void shape() {
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", new Validator().string().required());
        schemas.put("lastName", new Validator().string().required().minLength(2));
        schema.required().shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(schema.isValid(human3));
    }
}
