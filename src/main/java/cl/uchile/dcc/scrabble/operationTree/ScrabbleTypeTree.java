package cl.uchile.dcc.scrabble.operationTree;

import cl.uchile.dcc.scrabble.type.IType;

import java.util.ArrayList;

public abstract class Tree implements Component {
    protected IType ans;

    @Override
    public IType result() {
        return ans;
    }

    public void setResult() {

    }
}
