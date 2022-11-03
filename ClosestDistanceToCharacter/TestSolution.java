/* binarysearch.com :: Clostes Distance to Character
 * Tests
 * jramaswami
 */


import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class TestSolution {

    @Test
    public void test1() {
        String s = "aabaab";
        String c = "b";
        int[] expected = {2, 1, 0, 1, 1, 0};
        Solution solver = new Solution();
        int[] result = solver.solve(s, c);
        assertArrayEquals(expected, result);
    }
}
