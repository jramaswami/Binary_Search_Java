/* binarysearch.com :: The Auditor
 * Tests
 * jramaswami
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestSolution {

    @Test
    public void test1() {
        String s = "AA";
        int expected = 27;
        Solution solver = new Solution();
        int result = solver.solve(s);
        assertEquals(expected, result);
    }

}
