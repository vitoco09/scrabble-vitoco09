package cl.uchile.dcc.scrabble.operationTree.transformations;

import cl.uchile.dcc.scrabble.operationTree.Component;
import cl.uchile.dcc.scrabble.operationTree.AbstractTypeTree;

/**
 * Implementation of a ScrabbleType Unary Tree with the num-to-binary operation.
 */
public class ToBinaryTree extends AbstractTypeTree {

    protected Component component;

    /**
     * Constructor of a ToBinaryTree.
     * @param component Component which is the only children of the tree.
     */
    public ToBinaryTree(Component component) {
        this.component = component;
        this.setResult(component.getResult().toScrabbleBinary());
    }

    /**
     * pseudoCodeString: Method for printing pseudo-code for a tree.
     * @return
     */
    @Override
    public String pseudoCodeString() {
        return "ToBinary(" + component.pseudoCodeString() + ")";
    }
}
