package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema positive() {
        addToChecks("isPositive", i -> i == null || i > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addToChecks("isInRange", i -> i == null || (i >= min && i <= max));
        return this;
    }

    @Override
    public NumberSchema required() {
        addToChecks("!Null", Objects::nonNull);
        return this;
    }
}
