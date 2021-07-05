package cl.uchile.dcc.scrabble.type.typeFactory;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleFloat;

public class ScrabbleFloatFactory extends AbstractTypeFactory {

    /**
     * getScrabbleType: Method for getting a Scrabble Type, which uses a flyweight design where duplicates no longer
     * exist.
     * @param value double being the number of the desired Scrabble Type.
     * @return Result of the creation.
     */
    public static IType getScrabbleType(double value) {
        String name = String.valueOf(value);
        IType result = scrabbleTypes.get("FLOAT " + name);
        if (result == null) {
            result = new ScrabbleFloat(value);
            scrabbleTypes.put("FLOAT " + name, result);
        }
        return result;
    }

}
