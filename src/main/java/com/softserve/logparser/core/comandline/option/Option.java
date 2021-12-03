package com.softserve.logparser.core.comandline.option;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Option {

    private final Key key;
    private final String value;

    public Option(Key key) {
        this(key, "");
    }

    public Option(Key key, String value) {
        this.key = key;
        this.value = value;
    }

    public OptionType getType() {
        return key.getType();
    }

    public Key getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Option option = (Option) o;

        return key == option.key;
    }

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Option{");
        sb.append("key=").append(key);
        sb.append(", value='").append(value).append('\'');
        sb.append(", type='").append(getType()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
