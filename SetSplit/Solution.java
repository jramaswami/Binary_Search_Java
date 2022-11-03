/* binarysearch.com :: Set Split
 * jramaswami
 */


import java.util.Arrays;


class Solution {

    public boolean solve(int[] nums) {
        Arrays.sort(nums);

        int[] prefix = new int[nums.length];
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            prefix[i] = curr;
        }

        int[] suffix = new int[nums.length];
        curr = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            curr += nums[i];
            suffix[i] = curr;
        }

        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] < nums[i+1] && prefix[i] == suffix[i+1]) {
                return true;
            }
        }

        return false;
    }
}
