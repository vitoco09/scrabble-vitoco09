package cl.uchile.dcc.scrabble.type;

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

    public ScrabbleBool toBool() {
        return new ScrabbleBool(this.getValue());
    }

}
