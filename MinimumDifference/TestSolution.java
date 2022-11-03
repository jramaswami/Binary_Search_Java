/* binarysearch.com :: Minimum Difference
 * Tests
 * jramaswami
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TestSolution {

    @Test
    public void test1() {
        int[] lst0 = {1, 6, 3};
        int[] lst1 = {15, 9, 10};
        int expected = 3;
        Solution solver = new Solution();
        int result = solver.solve(lst0, lst1);
        assertEquals(expected, result);
    }
}

