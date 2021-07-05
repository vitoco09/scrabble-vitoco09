package cl.uchile.dcc.scrabble.type.typeFactory;

import cl.uchile.dcc.scrabble.type.IType;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of an abstract factory of Scrabble Types using a flyweight design for saving RAM.
 * Key has the format "TYPE keyValue" for testing purposes.
 */
public abstract class AbstractTypeFactory {

    /**
     * HashMap saving all allocated variables.
     */
    static Map<String, IType> scrabbleTypes = new HashMap<>();

}
