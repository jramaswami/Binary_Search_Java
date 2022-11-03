/* binarysearch.com :: Bounded Robot Moves
 * Tests
 * jramaswami
 */

import java.util.Arrays;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestSolution {

    @Test
    public void test1() {
        String s = "FFRRFF";
        Solution solver = new Solution();
        assertTrue(solver.solve(s));
    }

    @Test
    public void test2() {
        String s = "FF";
        Solution solver = new Solution();
        assertFalse(solver.solve(s));
    }

    @Test
    public void test3() {
        String s = "FL";
        Solution solver = new Solution();
        assertTrue(solver.solve(s));
    }

    @Test
    public void test4() {
        char[] A = new char[100000];
        Arrays.fill(A, 'F');
        String s = new String(A);
        Solution solver = new Solution();
        assertFalse(solver.solve(s));
    }

    @Test
    public void test5() {
        char[] A = new char[100000];
        Arrays.fill(A, 'F');
        A[A.length - 1] = 'L';
        A[A.length - 2] = 'L';
        String s = new String(A);
        Solution solver = new Solution();
        assertTrue(solver.solve(s));
    }

}
