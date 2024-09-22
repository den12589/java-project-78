package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
