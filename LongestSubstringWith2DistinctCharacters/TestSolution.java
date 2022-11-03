/* binarysearch.com :: Longest Substring with 2 Distinct Characters
 * Tests
 * jramaswami
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestSolution {

    @Test
    public void test1() {
        String s = "abccb";
        int expected = 4;
        Solution solver = new Solution();
        int result = solver.solve(s);
        assertEquals(result, expected);
    }
}
