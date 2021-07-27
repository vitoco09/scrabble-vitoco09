package cl.uchile.dcc.scrabble.operationTree;

/**
 * Implementation of a ScrabbleType Unary Tree with the negation operation.
 * For numbers it corresponds to multiplying by -1, while for logical values it corresponds to the logical complement.
 */
public class NegateTree extends AbstractTypeTree {

    protected Component component;

    /**
     * Constructor of a NegateTree.
     * @param component Component which is the only children of the tree.
     */
    public NegateTree(Component component) {
        this.component = component;
        this.setResult(component.getResult().negate());
    }

    /**
     * pseudoCodeString: Method for printing pseudo-code for a tree.
     * @return
     */
    @Override
    public String pseudoCodeString() {
        return "Negate(" + component.pseudoCodeString() + ")";
    }
}
