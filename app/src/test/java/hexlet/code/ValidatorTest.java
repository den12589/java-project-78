package hexlet.code;

import hexlet.code.schemas.StringSchema;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ValidatorTest {

    void chainMethods() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
    }

}
