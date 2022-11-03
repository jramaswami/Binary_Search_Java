import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestSolution {

    @Test
    public void test1() {
        int[] nums = {4, 9, 5};
        Solution solver = new Solution();
        assertTrue(solver.solve(nums));
    }

    @Test
    public void test2() {
        int[] nums = {9, 9};
        Solution solver = new Solution();
        assertFalse(solver.solve(nums));
    }

}
