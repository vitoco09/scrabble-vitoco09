package cl.uchile.dcc.scrabble.type;

public class ScrabbleBinary extends AbstractType{

    private String value;

    public ScrabbleBinary(String binary) {
        this.value = binary;
    }

    public String getValue() { return value; }

    @Override
    public String toString() {
        return this.getValue();
    }

    public ScrabbleBinary toBinary() {
        return new ScrabbleBinary(this.getValue());
    }

}
