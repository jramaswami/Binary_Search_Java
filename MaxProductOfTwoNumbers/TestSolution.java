/* binarysearch.com :: Max Product of Two Numbers
 * Tests
 * jramaswami
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestSolution {

    @Test
    public void test1() {
        int[] nums = {5, 1, 7};
        int expected = 35;
        Solution solver = new Solution();
        int result = solver.solve(nums);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {
        int[] nums = {7, 1, 7};
        int expected = 49;
        Solution solver = new Solution();
        int result = solver.solve(nums);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {
        int[] nums = {-5, 1, -7};
        int expected = 35;
        Solution solver = new Solution();
        int result = solver.solve(nums);
        assertEquals(expected, result);
    }
}
