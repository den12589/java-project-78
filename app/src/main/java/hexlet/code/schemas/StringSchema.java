package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public final StringSchema required() {
        checks.put("NonEmpty", s -> s != null && !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int min) {
        checks.put("isLonger", s -> s == null || s.length() >= min);
        return this;
    }

    public StringSchema contains(String subString) {
        checks.put("isContained", s -> s == null || s.contains(subString));
        return this;
    }
}
