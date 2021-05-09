package cl.uchile.dcc.scrabble.type;

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

}
