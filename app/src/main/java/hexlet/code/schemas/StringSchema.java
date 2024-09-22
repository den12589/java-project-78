package hexlet.code.schemas;

import java.util.Objects;

public class StringSchema extends BaseSchema<String> {

    public void required() {
        checks.add(Objects::nonNull);
        checks.add(s -> !s.isEmpty());
    }

    public void minLength(int min) {
        checks.add(s -> s.length() >= min);
    }

    public void contains(String subString) {
        checks.add(s -> s.contains(subString));
    }
}
