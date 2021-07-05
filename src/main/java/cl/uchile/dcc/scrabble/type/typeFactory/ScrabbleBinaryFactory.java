package cl.uchile.dcc.scrabble.type.typeFactory;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleBinary;

/**
 * Implementation of a Scrabble Binary Factory.
 */
public class ScrabbleBinaryFactory extends AbstractTypeFactory {

    /**
     * getScrabbleType: Method for getting a Scrabble Type, which uses a flyweight design where duplicates no longer
     * exist.
     * @param value String being the binary number of the desired Scrabble Type.
     * @return Result of the creation.
     */
    public static IType getScrabbleType(String value) {
        IType result = scrabbleTypes.get("BINARY " + value);
        if (result == null) {
            result = new ScrabbleBinary(value);
            scrabbleTypes.put("BINARY " + value, result);
        }
        return result;
    }

}
