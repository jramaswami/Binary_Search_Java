// binarysearch.com :: Flight Scheduling
// Tests
// jramaswami

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestSolution {
    @Test
    public void test1() {
        int[][] costs = { {1, 5}, {9, 2}, {3, 8}, {4, 7} };
        Solution solver = new Solution();
        int expected = 13;
        int result = solver.solve(costs);
        assertEquals(result, expected);
    }

}
