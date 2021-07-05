package cl.uchile.dcc.scrabble.operationTree;

import cl.uchile.dcc.scrabble.type.IType;

import java.util.ArrayList;

/**
 * Implementation of an abstract ScrabbleType Tree, which can emulate defined operations like sums and transformations.
 */
public abstract class ScrabbleTypeTree implements Component {

    protected IType ans;

    /**
     * getResult: Method that returns the result of an abstract syntax tree (AST)
     * @return IType being the result of the operation(s).
     */
    @Override
    public IType getResult() {
        return ans;
    }

    /**
     * setResult: Method that sets a result for an abstract syntax tree (AST)
     * @param result IType being the new result.
     */
    public void setResult(IType result) {
        ans = result;
    }
}
