package cl.uchile.dcc.scrabble.operationTree.transformations;

import cl.uchile.dcc.scrabble.operationTree.Component;
import cl.uchile.dcc.scrabble.operationTree.AbstractTypeTree;

/**
 * Implementation of a ScrabbleType Unary Tree with the type-to-bool operation.
 */
public class ToBoolTree extends AbstractTypeTree {

    protected Component component;

    /**
     * Constructor of a ToBoolTree.
     * @param component Component which is the only children of the tree.
     */
    public ToBoolTree(Component component) {
        this.component = component;
        this.setResult(component.getResult().toScrabbleBool());
    }

    /**
     * pseudoCodeString: Method for printing pseudo-code for a tree.
     * @return
     */
    @Override
    public String pseudoCodeString() {
        return "ToBool(" + component.pseudoCodeString() + ")";
    }
}
