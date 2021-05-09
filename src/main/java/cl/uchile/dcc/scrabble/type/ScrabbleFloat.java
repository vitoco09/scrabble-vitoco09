package cl.uchile.dcc.scrabble.type;

public class ScrabbleFloat extends AbstractType {

    private float value;

    public ScrabbleFloat(float f) {
        this.value = f;
    }

    public float getValue() { return value; }

    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }

    public ScrabbleFloat toFloat() {
        return new ScrabbleFloat(this.getValue());
    }

}
