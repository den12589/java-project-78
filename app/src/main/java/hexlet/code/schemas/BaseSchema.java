package hexlet.code.schemas;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    protected BaseSchema<T> required() {
        checks.put("NonNull", Objects::nonNull);
        return this;
    }

    public boolean isValid(T t) {
        for (Predicate<T> predicate : checks.values()) {
            if (!predicate.test(t)) {
                return false;
            }
        }
        return true;
    }
}
