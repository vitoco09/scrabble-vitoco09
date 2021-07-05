package cl.uchile.dcc.scrabble.operationTree;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.type.ScrabbleInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AddTreeTest {

    private AddTree simpleTree, mixedTree;

    @BeforeEach
    void setUp() {
        simpleTree = new AddTree(
                new ScrabbleInt(5),
                new ScrabbleInt(-30)
        );

        mixedTree = new AddTree(
                new ScrabbleFloat(5.346),
                new ScrabbleInt(10)
        );
    }

    @Test
    void AddTest() {
        IType result1 = simpleTree.getResult();
        assertEquals(result1, new ScrabbleInt(-25));

        IType result2 = mixedTree.getResult();
        assertEquals(result2, new ScrabbleFloat(15.346));

        IType result3 = new AddTree(simpleTree, mixedTree).getResult();
        assertEquals(result3, new ScrabbleFloat(-9.654));
    }
}
