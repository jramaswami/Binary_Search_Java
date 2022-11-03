/* binarysearch.com :: Bipartite Graph
 * Tests
 * jramaswami
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestSolution {

    @Test
    public void test1() {
        int[][] lines = {{2, 3}, {-3, 5}, {4, 6}};
        int lo = 0;
        int hi = 1;
        int expected = 2;
        Solution solver = new Solution();
        assertEquals(expected, solver.solve(lines, lo, hi));
    }

    @Test
    public void test2() {
        int[][] lines = { {-1, 0}, {-1, 1}, {-1, 2}, {-1, 3} };
        int lo = 0;
        int hi = 1;
        int expected = 0;
        Solution solver = new Solution();
        assertEquals(expected, solver.solve(lines, lo, hi));
    }

    @Test
    public void test3() {
        int[][] lines = { {0, 2} };
        int lo = -1;
        int hi = 0;
        int expected = 0;
        Solution solver = new Solution();
        assertEquals(expected, solver.solve(lines, lo, hi));
    }

    @Test
    public void test4() {
        int[][] lines = { {-1, -2} };
        int lo = 0;
        int hi = 0;
        int expected = 0;
        Solution solver = new Solution();
        assertEquals(expected, solver.solve(lines, lo, hi));
    }


    @Test
    public void test5() {
        int[][] lines = { {2, 3}, {3, 1}, };
        int lo = -2;
        int hi = 0;
        int expected = 0;
        Solution solver = new Solution();
        assertEquals(expected, solver.solve(lines, lo, hi));
    }

    @Test
    public void test6() {
        int[][] lines = { {-1, 0}, {3, 0} };
        int lo = 0;
        int hi = 0;
        int expected = 2;
        Solution solver = new Solution();
        assertEquals(expected, solver.solve(lines, lo, hi));
    }

    @Test
    public void test7() {
        // WA
        int[][] lines = { {-1, -3}, {0, -2}};
        int lo = -1;
        int hi = 0;
        int expected = 2;
        Solution solver = new Solution();
        assertEquals(expected, solver.solve(lines, lo, hi));
    }

    @Test
    public void test8() {
        // WA
        int[][] lines = { {-3, -3}, {-1, 2} };
        int lo = -3;
        int hi = 0;
        int expected = 2;
        Solution solver = new Solution();
        assertEquals(expected, solver.solve(lines, lo, hi));
    }

}
