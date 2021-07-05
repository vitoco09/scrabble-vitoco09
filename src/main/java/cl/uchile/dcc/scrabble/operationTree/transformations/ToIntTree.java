package cl.uchile.dcc.scrabble.operationTree.transformations;

import cl.uchile.dcc.scrabble.operationTree.Component;
import cl.uchile.dcc.scrabble.operationTree.AbstractTypeTree;

/**
 * Implementation of a ScrabbleType Unary Tree with the num-to-int operation.
 */
public class ToIntTree extends AbstractTypeTree {

    protected Component component;

    /**
     * Constructor of a ToIntTree.
     * @param component Component which is the only children of the tree.
     */
    public ToIntTree(Component component) {
        this.component = component;
        this.setResult(component.getResult().toScrabbleInt());
    }

}
