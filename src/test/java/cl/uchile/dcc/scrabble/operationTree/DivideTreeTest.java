package cl.uchile.dcc.scrabble.operationTree;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.type.ScrabbleInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideTreeTest {

    private DivideTree simpleTree, mixedTree;

    @BeforeEach
    void setUp() {
        simpleTree = new DivideTree(
                new ScrabbleInt(41),
                new ScrabbleInt(-9)
        );

        mixedTree = new DivideTree(
                new ScrabbleFloat(5.346),
                new ScrabbleInt(10)
        );
    }

    @Test
    void AddTest() {
        IType result1 = simpleTree.getResult();
        assertEquals(result1, new ScrabbleInt(-4));

        IType result2 = mixedTree.getResult();
        assertEquals(result2, new ScrabbleFloat(0.5346));

        IType result3 = new DivideTree(simpleTree, mixedTree).getResult();
        assertEquals(result3, new ScrabbleFloat(-7.482229704451927));
    }

}
