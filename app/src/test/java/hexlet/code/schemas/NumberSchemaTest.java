package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class NumberSchemaTest {

    private NumberSchema schema;

    @BeforeEach
    void setup() {
        schema = new Validator().number();
    }

    @Test
    void required() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(6));
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    void positive() {
        assertTrue(schema.isValid(0));
        assertTrue(schema.isValid(-7));
        schema.positive();
        assertTrue(schema.isValid(9));
        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(-7));
        assertFalse(schema.isValid(null));
    }

    @Test
    void range() {
        assertTrue(schema.isValid(4));
        assertTrue(schema.isValid(11));
        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(null));
    }
}
