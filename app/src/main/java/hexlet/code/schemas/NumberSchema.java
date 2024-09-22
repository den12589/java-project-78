package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public void positive() {
        checks.add(i -> i > 0);
    }

    public void range(int min, int max) {
        checks.add(i -> i >= min && i <= max);
    }
}
