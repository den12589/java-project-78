package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private final Map<String, Predicate<T>> checks = new HashMap<>();

    /**
     * Non null check.
     *
     * @return BaseSchema<T>
     */
    public BaseSchema<T> required() {
        addToChecks("Required", Objects::nonNull);
        return this;
    }

    final void addToChecks(String name, Predicate<T> check) {
        checks.put(name, check);
    }

    public final boolean isValid(T t) {
        for (Predicate<T> predicate : checks.values()) {
            if (!predicate.test(t)) {
                return false;
            }
        }
        return true;
    }
}
