/* binarysearch.com :: Reverse a Linked List
 * jramaswami
 */

import java.util.Random;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import com.binarysearch.LLNode;

public class TestSolution {

    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 4};
        LLNode root = LLNode.fromArray(arr);
        int[] expected = {4, 3, 2, 1};
        Solution solver = new Solution();
        LLNode root0 = solver.solve(root);
        int[] result = LLNode.toArray(root0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {
        int[] arr = {0, 1};
        LLNode root = LLNode.fromArray(arr);
        int[] expected = {1, 0};
        Solution solver = new Solution();
        LLNode root0 = solver.solve(root);
        int[] result = LLNode.toArray(root0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRandom() {
        for (int t = 0; t < 100; t++) {
            Random rand = new Random();
            int N = 1 + rand.nextInt(10000);
            int[] arr = new int[N];
            int[] expected = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = i;
                expected[i] = N - i - 1;
            }
            LLNode root = LLNode.fromArray(arr);
            Solution solver = new Solution();
            LLNode root0 = solver.solve(root);
            int[] result = LLNode.toArray(root0);
            assertArrayEquals(expected, result);
        }
    }
}
