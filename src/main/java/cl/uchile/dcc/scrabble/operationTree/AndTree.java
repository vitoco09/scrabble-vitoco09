package cl.uchile.dcc.scrabble.operationTree;

/**
 * Implementation of a ScrabbleType Binary Tree with the logical conjunction operation.
 */
public class AndTree extends AbstractTypeTree {

    protected Component left, right;

    /**
     * Constructor of an AndTree.
     * @param left Component which is the left children.
     * @param right Component which is the right children.
     */
    public AndTree(Component left, Component right) {
        this.left = left;
        this.right = right;
        this.setResult(left.getResult().and(right.getResult()));
    }

    /**
     * pseudoCodeString: Method for printing pseudo-code for a tree.
     * @return
     */
    @Override
    public String pseudoCodeString() {
        return "And(" + left.pseudoCodeString() + ", " + right.pseudoCodeString() + ")";
    }
}
