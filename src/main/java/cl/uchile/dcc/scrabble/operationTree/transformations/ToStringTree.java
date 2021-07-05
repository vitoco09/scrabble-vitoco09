package cl.uchile.dcc.scrabble.operationTree.transformations;

import cl.uchile.dcc.scrabble.operationTree.Component;
import cl.uchile.dcc.scrabble.operationTree.AbstractTypeTree;

/**
 * Implementation of a ScrabbleType Unary Tree with the type-to-string operation.
 */
public class ToStringTree extends AbstractTypeTree {

    protected Component component;

    /**
     * Constructor of a ToStringTree.
     * @param component Component which is the only children of the tree.
     */
    public ToStringTree(Component component) {
        this.component = component;
        this.setResult(component.getResult().toScrabbleString());
    }

}
