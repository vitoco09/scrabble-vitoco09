package cl.uchile.dcc.scrabble.type;

import java.util.Objects;

public class ScrabbleString extends AbstractType {

    private String value;

    public ScrabbleString(String string) {
        this.value = string;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() { return this.getValue(); }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleString.class, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleString) {
            var o = (ScrabbleString) obj;
            return this.getValue().equals(o.getValue());
        }
        return false;
    }

}
