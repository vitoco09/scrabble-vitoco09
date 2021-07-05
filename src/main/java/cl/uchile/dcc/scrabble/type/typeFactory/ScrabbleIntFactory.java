package cl.uchile.dcc.scrabble.type.typeFactory;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleInt;

import java.util.UUID;

public class ScrabbleIntFactory extends AbstractTypeFactory {

    /**
     * getScrabbleType: Method for getting a Scrabble Type, which uses a flyweight design where duplicates no longer
     * exist.
     * @param value int being the number of the desired Scrabble Type.
     * @return Result of the creation.
     */
    public static IType getScrabbleType(int value) {
        String name = String.valueOf(value);
        IType result = scrabbleTypes.get("INT " + value);
        if (result == null) {
            result = new ScrabbleInt(value);
            scrabbleTypes.put("INT " + name, result);
        }
        return result;
    }

}
