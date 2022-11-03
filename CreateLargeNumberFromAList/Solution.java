/*
 * binarysearch.com :: Create Largest Number From a List
 * jramaswami
 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class Solution {

    // Since nums[i] <= 1000 we can get the multiplier necessary to
    // combine numbers into a single number.
    private int getMultiplier(int value) {
        if (value < 10) {
            // Atop a single number e.g. X and Y --> Y0 + X = YX
            return 10;
        } else if (value < 100) {
            // Atop a single number e.g. XX and Y --> Y00 + XX = YXX
            return 100;
        } else if (value < 1000) {
            // Atop a single number e.g. XXX and Y --> Y000 + YXXX
            return 1000;
        }
        // Atop a single number e.g. XXXX and Y --> Y0000 + XXXX = YXXXX
        return 10000;
    }

    // Concatenate a to b
    private int concat(int a, int b) {
        int m = getMultiplier(b);
        return (a * m) + b;
    }

    private class SolutionComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if (a.equals(b)) {
                return 0;
            }
            if (concat(a, b) > concat(b, a)) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public String solve(int[] nums) {
        // Base case
        if (nums.length == 0) {
            return "0";
        }
        ArrayList<Integer> nums0 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums0.add(Integer.valueOf(nums[i]));
        }
        Collections.sort(nums0, new SolutionComparator());
        StringBuilder sb = new StringBuilder();
        for (Integer i : nums0) {
            sb.append(i.toString());
        }
        return sb.toString();
    }
}
