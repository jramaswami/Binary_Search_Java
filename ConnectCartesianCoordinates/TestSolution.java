/* binarysearch.com :: Connect Cartesian Coordinates
 * Tests
 * jramaswami
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestSolution {

    @Test
    public void test1() {
        int[][] points = { {0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        int expected = 4;
        Solution solver = new Solution();
        int result = solver.solve(points);
        assertEquals(expected, result);
    }

}
