/* LeetCode :: Sum of Three Numbers Trequel
 * Tests
 * jramaswami
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestSolution {

    @Test
    public void test1() {
        int[] nums = {9, 1, 5, 3, 4};
        int expected = 8;
        Solution solver = new Solution();
        int result = solver.solve(nums);
        assertEquals(expected, result);
    }
}
