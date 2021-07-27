package cl.uchile.dcc.scrabble.operationTree;

/**
 * Implementation of a ScrabbleType Binary Tree with the subtraction operation.
 */
public class SubtractTree extends AbstractTypeTree {

    protected Component left, right;

    /**
     * Constructor of a SubtractTree.
     * @param left Component which is the left children.
     * @param right Component which is the right children.
     */
    public SubtractTree(Component left, Component right) {
        this.left = left;
        this.right = right;
        this.setResult(left.getResult().subtract(right.getResult()));
    }

    /**
     * pseudoCodeString: Method for printing pseudo-code for a tree.
     * @return
     */
    @Override
    public String pseudoCodeString() {
        return "Subtract(" + left.pseudoCodeString() + ", " + right.pseudoCodeString() + ")";
    }
}
