package cl.uchile.dcc.scrabble.type.typeFactory;

import cl.uchile.dcc.scrabble.type.IType;

import java.util.HashMap;
import java.util.Map;

public abstract class ITypeFactory {

    static Map<String, IType> scrabbleTypes = new HashMap<>();

    public static IType getScrabbleType(String name) {
        IType result = scrabbleTypes.get(name);
        if (result == null) {
            
        }
        return result;
    }

}
