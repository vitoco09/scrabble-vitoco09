package cl.uchile.dcc.scrabble.type;

import java.util.Objects;

public class ScrabbleFloat extends AbstractType implements INumber {

    private double value;

    public ScrabbleFloat(double f) {
        this.value = f;
    }

    public double getValue() { return value; }

    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleFloat.class, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleFloat) {
            var o = (ScrabbleFloat) obj;
            return this.getValue() == o.getValue();
        }
        return false;
    }

    public ScrabbleFloat toScrabbleFloat() {
        return new ScrabbleFloat(this.getValue());
    }

}
