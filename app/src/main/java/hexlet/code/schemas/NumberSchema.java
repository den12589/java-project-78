package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema positive() {
        checks.put("isPositive", i -> i > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        checks.put("isInRange", i -> i >= min && i <= max);
        return this;
    }
}
