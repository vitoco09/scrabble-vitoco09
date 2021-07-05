package cl.uchile.dcc.scrabble.type.typeFactory;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleString;

public class ScrabbleStringFactory extends AbstractTypeFactory {

    /**
     * getScrabbleType: Method for getting a Scrabble Type, which uses a flyweight design where duplicates no longer
     * exist.
     * @param value String int being the value of the desired Scrabble Type.
     * @return Result of the creation.
     */
    public static IType getScrabbleType(String value) {
        IType result = scrabbleTypes.get("STRING " + value);
        if (result == null) {
            result = new ScrabbleString(value);
            scrabbleTypes.put("STRING " + value, result);
        }
        return result;
    }

}
