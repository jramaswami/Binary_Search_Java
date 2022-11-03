/* LeetCode :: Sum of Three Numbers Trequel
 * jramaswami
 */

import java.util.TreeSet;

class Solution {
    public int solve(int[] nums) {
        int N = nums.length;

        int[] maxSuffix = new int[N+1];
        maxSuffix[N] = Integer.MIN_VALUE;
        for (int i = N-1; i >= 0; --i) {
            maxSuffix[i] = Math.max(maxSuffix[i+1], nums[i]);
        }

        int soln = Integer.MIN_VALUE;
        TreeSet<Integer> prefix = new TreeSet<Integer>();
        for (int i = 0; i < N; ++i) {
            if (prefix.floor(nums[i]) == null) {
                prefix.add(nums[i]);
                continue;
            }
            int left = prefix.floor(nums[i]);
            int right = maxSuffix[i+1];
            if (left <= nums[i] && nums[i] <= right) {
                soln = Math.max(soln, left + nums[i] + right);
            }
            prefix.add(nums[i]);
        }
        return soln;
    }
}
