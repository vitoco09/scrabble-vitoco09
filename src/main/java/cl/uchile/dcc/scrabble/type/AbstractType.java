package cl.uchile.dcc.scrabble.type;

public abstract class AbstractType implements IType {

    @Override
    public abstract String toString();

    @Override
    public ScrabbleString toScrabbleString() {
        return new ScrabbleString(this.toString());
    }

}
