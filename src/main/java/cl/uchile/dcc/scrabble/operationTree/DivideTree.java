package cl.uchile.dcc.scrabble.operationTree;

/**
 * Implementation of a ScrabbleType Binary Tree with the division operation.
 */
public class DivideTree extends AbstractTypeTree {

    protected Component left, right;

    /**
     * Constructor of a DivideTree.
     * @param left Component which is the left children.
     * @param right Component which is the right children.
     */
    public DivideTree(Component left, Component right) {
        this.left = left;
        this.right = right;
        this.setResult(left.getResult().divide(right.getResult()));
    }
}
