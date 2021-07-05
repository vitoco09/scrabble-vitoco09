package cl.uchile.dcc.scrabble.operationTree;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.type.ScrabbleInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyTreeTest {

    private MultiplyTree simpleTree, mixedTree;

    @BeforeEach
    void setUp() {
        simpleTree = new MultiplyTree(
                new ScrabbleInt(5),
                new ScrabbleInt(-30)
        );

        mixedTree = new MultiplyTree(
                new ScrabbleFloat(5.346),
                new ScrabbleInt(10)
        );
    }

    @Test
    void AddTest() {
        IType result1 = simpleTree.getResult();
        assertEquals(result1, new ScrabbleInt(-150));

        IType result2 = mixedTree.getResult();
        assertEquals(result2, new ScrabbleFloat(53.46));

        IType result3 = new MultiplyTree(simpleTree, mixedTree).getResult();
        assertEquals(result3, new ScrabbleFloat(-8019));
    }

}
