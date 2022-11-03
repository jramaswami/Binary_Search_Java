/* binarysearch.com :: Clostes Distance to Character
 * jramaswami
 */


class Solution {
    public int[] solve(String s, String c) {
        int[] prefixDist = new int[s.length()];
        int[] suffixDist = new int[s.length()];

        int currDist = s.length();
        for (int i = 0; i < s.length(); i++) {
            currDist++;
            if (s.charAt(i) == c.charAt(0)) {
                currDist = 0;
            }
            prefixDist[i] = currDist;
        }

        currDist = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            currDist++;
            if (s.charAt(i) == c.charAt(0)) {
                currDist = 0;
            }
            suffixDist[i] = currDist;
        }

        int[] soln = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            soln[i] = Math.min(prefixDist[i], suffixDist[i]);
        }
        return soln;
    }
}
