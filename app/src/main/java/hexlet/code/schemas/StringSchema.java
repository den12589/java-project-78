package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        super.required();
        checks.add(s -> !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int min) {
        checks.add(s -> s.length() >= min);
        return this;
    }

    public StringSchema contains(String subString) {
        checks.add(s -> s.contains(subString));
        return this;
    }
}
