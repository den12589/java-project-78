package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema positive() {
        checks.put("isPositive", i -> i == null || i > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        checks.put("isInRange", i -> i == null || (i >= min && i <= max));
        return this;
    }

    public NumberSchema required() {
        checks.put("NonNull", Objects::nonNull);
        return this;
    }
}
