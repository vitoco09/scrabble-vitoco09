package cl.uchile.dcc.scrabble.type;

public class ScrabbleInt extends AbstractType {

    private int value;

    public ScrabbleInt(int i) {
        this.value = i;
    }

    public int getValue() { return value; }

    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }

    public ScrabbleFloat toFloat() {
        return new ScrabbleFloat(Float.parseFloat(this.toString()));
    }
    public ScrabbleInt toInt() {
        return new ScrabbleInt(this.getValue());
    }

}
