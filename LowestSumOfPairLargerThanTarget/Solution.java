/* binarysearch.com :: Lowest Sum of Pair Larger than Target
 * jramaswami
 */

import java.util.Arrays;

public class Solution {

    public int solve(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int soln = Integer.MAX_VALUE;
        while (left < right) {
            while (left < right && nums[left] + nums[right] > target) {
                soln = Math.min(soln, nums[left] + nums[right]);
                right--;
            }
            left++;
        }
        return soln;
    }

}
