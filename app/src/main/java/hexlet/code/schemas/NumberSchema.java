package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema positive() {
        checks.put("isPositive", i -> i == null || i > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        checks.put("isInRange", i -> i == null || (i >= min && i <= max));
        return this;
    }

    public NumberSchema required() {
        super.required();
        return this;
    }
}
