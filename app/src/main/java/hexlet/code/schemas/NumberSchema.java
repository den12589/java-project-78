package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public void positive() {
        checks.put("isPositive", i -> i > 0);
    }

    public void range(int min, int max) {
        checks.put("isInRange", i -> i >= min && i <= max);
    }
}
