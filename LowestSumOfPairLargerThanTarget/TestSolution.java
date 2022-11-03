/* binarysearch.com :: Lowest Sum of Pair Larger than Target
 * Tests
 * jramaswami
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestSolution {

    @Test
    public void test1() {
        int[] nums = {1, 3, 5, 9, 13};
        int target = 8;
        int expected = 10;
        Solution solver = new Solution();
        int result = solver.solve(nums, target);
        assertEquals(expected, result);
    }

}
