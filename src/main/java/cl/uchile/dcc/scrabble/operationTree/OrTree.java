package cl.uchile.dcc.scrabble.operationTree;

/**
 * Implementation of a ScrabbleType Binary Tree with the logical disjunction operation.
 */
public class OrTree extends AbstractTypeTree {

    protected Component left, right;

    /**
     * Constructor of an OrTree.
     * @param left Component which is the left children.
     * @param right Component which is the right children.
     */
    public OrTree(Component left, Component right) {
        this.left = left;
        this.right = right;
        this.setResult(left.getResult().or(right.getResult()));
    }
}
