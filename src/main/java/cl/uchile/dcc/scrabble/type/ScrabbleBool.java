package cl.uchile.dcc.scrabble.type;

import java.util.Objects;

public class ScrabbleBool extends AbstractType {

    private boolean value;

    public ScrabbleBool(boolean bool) {
        this.value = bool;
    }

    public boolean getValue() { return value; }

    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleBool.class, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleBool) {
            var o = (ScrabbleBool) obj;
            return this.getValue() == o.getValue();
        }
        return false;
    }

    public ScrabbleBool toScrabbleBool() {
        return new ScrabbleBool(this.getValue());
    }

}
