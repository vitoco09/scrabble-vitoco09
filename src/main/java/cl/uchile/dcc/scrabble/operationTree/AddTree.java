package cl.uchile.dcc.scrabble.operationTree;

/**
 * Implementation of a ScrabbleType Binary Tree with the sum operation.
 */
public class AddTree extends AbstractTypeTree {

    protected Component left, right;

    /**
     * Constructor of an AddTree.
     * @param left Component which is the left children.
     * @param right Component which is the right children.
     */
    public AddTree(Component left, Component right) {
        this.left = left;
        this.right = right;
        this.setResult(left.getResult().add(right.getResult()));
    }

}
