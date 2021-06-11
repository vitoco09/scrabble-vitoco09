package cl.uchile.dcc.scrabble.type;

/**
 * Implementation of an interface for a Scrabble logical type.
 * @author Victor Vidal Paz
 */
public interface ILogical {

    /**
     * and: Logical conjunction operator between two Scrabble logical types.
     * @param sLogical ScrabbleLogical type to operate on the right side.
     * @return ILogical being the result of the conjunction.
     */
    ILogical and(ILogical sLogical);

    /**
     * or: Logical disjunction operator between two Scrabble logical types.
     * @param sLogical ScrabbleLogical type to operate on the right side.
     * @return ILogical being the result of the disjunction.
     */
    ILogical or(ILogical sLogical);

}
