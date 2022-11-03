/* binarysearch.com :: Largest Equivalent Set of Pairs
 * jramaswami
 */

public class Solution {


    public int solve(int[] nums) {
        // double knapsack
        int max_sum = 0;
        for (int n : nums) { max_sum += n; }
        max_sum /= 2;

        final boolean[][][] dp = new boolean[nums.length][max_sum+1][max_sum+1];

        // dp[index][w1][w2]
        int soln = 0;
        dp[0][0][0] = true;
        if (nums[0] <= max_sum) {
            dp[0][nums[0]][0] = true;
            dp[0][0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; ++i) {
            int n = nums[i];
            for (int w1 = 0; w1 <= max_sum; ++w1) {
                for (int w2 = 0; w2 <= max_sum; ++w2) {
                    if (dp[i-1][w1][w2]) {
                        // Can I add it to w1?
                        if ((w1 + n) <= max_sum) {
                            dp[i][w1+n][w2] = true;
                            if (w1 + n  == w2) {
                                soln = Math.max(soln, w2);
                            }
                        }
                        // Can I add it to w2?
                        if ((w2 + n) <= max_sum) {
                            dp[i][w1][w2+n] = true;
                            if (w2 + n  == w1) {
                                soln = Math.max(soln, w1);
                            }
                        }
                        // I can always chuck n!
                        dp[i][w1][w2] = true;
                        if (w2 == w1) {
                            soln = Math.max(soln, w1);
                        }
                    }
                }
            }
        }
        return soln;
    }
}
