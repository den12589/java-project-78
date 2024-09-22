package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {
    public void required() {
        checks.add(Objects::nonNull);
    }

    public void positive() {
        checks.add(i -> i > 0);
    }

    public void range(int min, int max) {
        checks.add(i -> i >= min && i <= max);
    }
}
