package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected List<Predicate<T>> checks = new ArrayList<>();

    public void required() {
        checks.add(Objects::nonNull);
    }

    public boolean isValid(T t) {
        for (Predicate<T> predicate : checks) {
            if (!predicate.test(t)) {
                return false;
            }
        }
        return true;
    }
}
