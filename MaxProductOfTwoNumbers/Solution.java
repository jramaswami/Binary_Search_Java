/* binarysearch.com :: Max Product of Two Numbers
 * jramaswami
 */

import java.util.Arrays;

class Solution {
    public int solve(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length - 1;
        return Math.max( (nums[0] * nums[1]), (nums[N-1] * nums[N]) );
    }
}
