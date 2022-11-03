/* binarysearch.com :: Bipartite Graph
 * Tests
 * jramaswami
 */

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestSolution {

    @Test
    public void test1() {
        int[][] adj = {{1}, {0}};
        Solution solver = new Solution();
        assertTrue(solver.solve(adj));
    }

    @Test
    public void test2() {
        int[][] adj = {{2, 3}, {2, 3}, {0, 1}, {0, 1}};
        Solution solver = new Solution();
        assertTrue(solver.solve(adj));
    }

    @Test
    public void test3() {
        int[][] adj = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        Solution solver = new Solution();
        assertFalse(solver.solve(adj));
    }

}
