package cl.uchile.dcc.scrabble.type.typeFactory;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleBool;

public class ScrabbleBoolFactory extends AbstractTypeFactory {

    /**
     * getScrabbleType: Method for getting a Scrabble Type, which uses a flyweight design where duplicates no longer
     * exist.
     * @param value boolean being the value of the desired Scrabble Type.
     * @return Result of the creation.
     */
    public static IType getScrabbleType(boolean value) {
        String name = String.valueOf(value);
        IType result = scrabbleTypes.get("BOOL " + name);
        if (result == null) {
            result = new ScrabbleBool(value);
            scrabbleTypes.put("BOOL " + name, result);
        }
        return result;
    }


}
