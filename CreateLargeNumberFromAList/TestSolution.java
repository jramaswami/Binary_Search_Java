import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TestSolution {

    @Test
    public void test1() {
        int[] nums = {10, 7, 76, 415};
        Solution solver = new Solution();
        String result = solver.solve(nums);
        String expected = "77641510";
        assertEquals(result, expected);
    }

    @Test
    public void test2() {
        int[] nums = {961, 745, 331, 794, 923};
        Solution solver = new Solution();
        String result = solver.solve(nums);
        String expected = "961923794745331";
        assertEquals(result, expected);
    }

    @Test
    public void test3() {
        int[] nums = {45, 14, 70, 67, 95};
        Solution solver = new Solution();
        String result = solver.solve(nums);
        String expected = "9570674514";
        assertEquals(result, expected);
    }

    @Test
    public void test4() {
        int[] nums = {70, 5, 94, 18, 78};
        Solution solver = new Solution();
        String result = solver.solve(nums);
        String expected = "947870518";
        assertEquals(result, expected);
    }

    @Test
    public void test5() {
        int[] nums = {};
        Solution solver = new Solution();
        String result = solver.solve(nums);
        String expected = "0";
        assertEquals(result, expected);
    }

    @Test
    public void test6() {
        int[] nums = {1, 12};
        Solution solver = new Solution();
        String result = solver.solve(nums);
        String expected = "121";
        assertEquals(result, expected);
    }
}
