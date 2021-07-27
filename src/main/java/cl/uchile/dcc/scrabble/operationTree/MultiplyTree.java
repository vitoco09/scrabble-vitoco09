package cl.uchile.dcc.scrabble.operationTree;

/**
 * Implementation of a ScrabbleType Binary Tree with the multiplication operation.
 */
public class MultiplyTree extends AbstractTypeTree {

    protected Component left, right;

    /**
     * Constructor of a MultiplyTree.
     * @param left Component which is the left children.
     * @param right Component which is the right children.
     */
    public MultiplyTree(Component left, Component right) {
        this.left = left;
        this.right = right;
        this.setResult(left.getResult().multiply(right.getResult()));
    }

    /**
     * pseudoCodeString: Method for printing pseudo-code for a tree.
     * @return
     */
    @Override
    public String pseudoCodeString() {
        return "Multiply(" + left.pseudoCodeString() + ", " + right.pseudoCodeString() + ")";
    }
}
