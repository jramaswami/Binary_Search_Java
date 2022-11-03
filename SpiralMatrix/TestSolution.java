/* binarysearch.com :: Spiral Matrix
 * Tests
 * jramaswami
 */


import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.util.Arrays;


public class TestSolution {

    @Test
    public void test1() {
        int[][] matrix = { {6, 9, 8}, {1, 8, 0}, {5, 1, 2}, {8, 0, 3},
                           {1, 6, 4}, {8, 8, 10} };
        Solution solver = new Solution();
        int[] result = solver.solve(matrix);
        int[] expected = {6, 9, 8, 0, 2, 3, 4, 10, 8, 8, 1, 8, 5, 1, 8, 1, 0, 6};
        System.out.println("r " + Arrays.toString(result));
        System.out.println("e " + Arrays.toString(expected));
        assertArrayEquals(result, expected);
    }

    @Test
    public void test2() {
        int[][] matrix = { {1} };
        Solution solver = new Solution();
        int[] result = solver.solve(matrix);
        int[] expected = {1};
        System.out.println("r " + Arrays.toString(result));
        System.out.println("e " + Arrays.toString(expected));
        assertArrayEquals(result, expected);
    }

    @Test
    public void test3() {
        int[][] matrix = new int[0][0];
        Solution solver = new Solution();
        int[] result = solver.solve(matrix);
        int[] expected = new int[0];
        System.out.println("r " + Arrays.toString(result));
        System.out.println("e " + Arrays.toString(expected));
        assertArrayEquals(result, expected);
    }

    @Test
    public void test4() {
        int[][] matrix = new int[1][0];
        Solution solver = new Solution();
        int[] result = solver.solve(matrix);
        int[] expected = new int[0];
        System.out.println("r " + Arrays.toString(result));
        System.out.println("e " + Arrays.toString(expected));
        assertArrayEquals(result, expected);
    }
}

