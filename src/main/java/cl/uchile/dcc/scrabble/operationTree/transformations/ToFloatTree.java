package cl.uchile.dcc.scrabble.operationTree.transformations;

import cl.uchile.dcc.scrabble.operationTree.Component;
import cl.uchile.dcc.scrabble.operationTree.AbstractTypeTree;

/**
 * Implementation of a ScrabbleType Unary Tree with the num-to-float operation.
 */
public class ToFloatTree extends AbstractTypeTree {

    protected Component component;

    /**
     * Constructor of a ToFloatTree.
     * @param component Component which is the only children of the tree.
     */
    public ToFloatTree(Component component) {
        this.component = component;
        this.setResult(component.getResult().toScrabbleFloat());
    }

    /**
     * pseudoCodeString: Method for printing pseudo-code for a tree.
     * @return
     */
    @Override
    public String pseudoCodeString() {
        return "ToFloat(" + component.pseudoCodeString() + ")";
    }
}
