package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        super.required();
        checks.put("NonEmpty", s -> !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int min) {
        checks.put("isLonger", s -> s.length() >= min);
        return this;
    }

    public StringSchema contains(String subString) {
        checks.put("isContained", s -> s.contains(subString));
        return this;
    }
}
