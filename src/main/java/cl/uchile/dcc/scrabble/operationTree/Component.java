package cl.uchile.dcc.scrabble.operationTree;

import cl.uchile.dcc.scrabble.type.IType;

/**
 * Implementation of a Component interface. It emulates the behaviour of an abstract syntax tree (AST) and its children,
 * and its intention is to communicate the different types with the tree itself.
 */
public interface Component {

    /**
     * getResult: Method that returns the result of an abstract syntax tree (AST)
     * @return IType being the result of the operation(s).
     */
    IType getResult();

}
