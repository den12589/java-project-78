package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class StringSchemaTest {

    private StringSchema schema;

    @BeforeEach
    void setup() {
        schema = new Validator().string();
    }

    @Test
    void required() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
    }

    @Test
    void minLength() {
        schema.minLength(3);
        assertTrue(schema.isValid("12345"));
        assertTrue(schema.isValid("123"));
        assertFalse(schema.isValid("12"));
    }

    @Test
    void contains() {
        schema.contains("123");
        assertTrue(schema.isValid("qwe123ertt231"));
        assertFalse(schema.isValid("qwe3212221ewq"));
    }
}
