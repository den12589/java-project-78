package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    @Override
    StringSchema required() {
        addToChecks("Required", s -> s != null && !s.isEmpty());
        return this;
    }

    StringSchema minLength(int min) {
        addToChecks("isLonger", s -> s == null || s.length() >= min);
        return this;
    }

    StringSchema contains(String subString) {
        addToChecks("isContained", s -> s == null || s.contains(subString));
        return this;
    }
}
