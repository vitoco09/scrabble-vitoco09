package cl.uchile.dcc.scrabble.operationTree;

public class ToIntTree extends ScrabbleTypeTree {

    protected Component component;

    public ToIntTree(Component component) {
        this.component = component;
        this.setResult(component.getResult().toScrabbleInt());
    }
}
