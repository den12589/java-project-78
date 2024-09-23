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
    void requiredTest() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(6));
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    void positiveTest() {
        assertTrue(schema.isValid(0));
        assertTrue(schema.isValid(-7));
        schema.positive();
        assertTrue(schema.isValid(9));
        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(-7));
        assertTrue(schema.isValid(null));
    }

    @Test
    void rangeTest() {
        assertTrue(schema.isValid(4));
        assertTrue(schema.isValid(11));
        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertTrue(schema.isValid(null));
    }

    @Test
    void chainTest() {
        assertTrue(schema.isValid(null));

        schema.required().positive();
        assertTrue(schema.isValid(1));
        assertFalse(schema.isValid(-1));
        assertFalse(schema.isValid(null));


        schema = new Validator().number().range(-1, 5).positive();
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(0));
    }
}
