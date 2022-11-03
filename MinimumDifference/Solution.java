/* binarysearch.com :: Minimum Difference
 * jramaswami
 *
 * Sorting and two pointer method.
 */

import java.util.Arrays;

class Solution {
    public int solve(int[] lst0, int[] lst1) {
        Arrays.sort(lst0);
        Arrays.sort(lst1);

        int soln = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < lst0.length; i++) {
            // Find first element greater than lst0[i].
            while (j < lst1.length && lst1[j] < lst0[i]) {
                j++;
            }
            // Compare to first element less than or equal to A[i].
            if (j > 0) {
                soln = Math.min(soln, lst0[i] - lst1[j-1]);
            }
            // Compare to the first element greater than A[i].
            if (j < lst1.length) {
                soln = Math.min(soln, lst1[j] - lst0[i]);
            }
        }
        return soln;
    }
}
