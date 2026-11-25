import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BSTTest {

    @Test
    void emptyTreeHasHeightMinusOne() {
        BST tree = new BST();
        assertEquals(-1, tree.height());
    }

    @Test
    void singleNodeHasHeightZero() {
        BST tree = new BST();
        tree.insert(5);
        assertEquals(0, tree.height());
    }

    @Test
    void balancedTreeHasHeightOne() {
        BST tree = new BST();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        assertEquals(1, tree.height());
    }

    @Test
    void sortedInsertsMakeAStraightLine() {
        // 1 -> 2 -> 3 -> 4
        BST tree = new BST();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        assertEquals(3, tree.height());
    }

    @Test
    void findCountsNodesVisited() {
        BST tree = new BST();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        assertEquals(1, tree.find(5));
        assertEquals(2, tree.find(3));
        assertEquals(2, tree.find(8));
        assertEquals(3, tree.find(1));
    }

    @Test
    void duplicatesAreIgnored() {
        BST tree = new BST();
        tree.insert(5);
        tree.insert(5);
        tree.insert(5);
        assertEquals(0, tree.height());
        assertEquals(1, tree.find(5));
    }
}
