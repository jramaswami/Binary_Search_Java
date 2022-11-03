/* binarysearch.com :: Bipartite Graph
 * Tests
 * jramaswami
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestSolution {

    @Test
    public void test1() {
        int[] nums = {21, 64, 99, 36, 45, 40, 34, 78, 57, 19, 85, 92, 54, 94, 41, 59, 25, 70, 61, 69, 67, 41, 25, 29, 63, 38, 80, 87, 91, 63};
        Solution solver = new Solution();
        assertEquals(solver.solve(nums), 854);
    }

    @Test
    public void test2() {
        int[] nums = {1, 4, 3, 5};
        Solution solver = new Solution();
        assertEquals(solver.solve(nums), 5);
    }

    @Test
    public void test3() {
        int[] nums = new int[30];
        for (int i = 1; i <= 30; i++) {
            nums[i-1] = i;
        }
        Solution solver = new Solution();
        assertEquals(solver.solve(nums), 232);
    }

    @Test
    public void test4() {
        // WA
        int[] nums = {2, 16, 26, 24, 14, 12, 29, 4};
        Solution solver = new Solution();
        assertEquals(solver.solve(nums), 42);
    }

    @Test
    public void test5() {
        // TLE: accumulation
        int[] nums = {12,3,2,30,19,28,16,16};
        Solution solver = new Solution();
        assertEquals(solver.solve(nums), 63);
    }

    @Test
    public void test6() {
        // RTE
        int[] nums = {10,2,2};
        Solution solver = new Solution();
        assertEquals(solver.solve(nums), 2);
    }
}
