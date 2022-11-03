/* binarysearch.com :: The Auditor
 * jramaswami
 */

public class Solution {
    public int solve(String s) {
        int soln = 0;
        int mult = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int c = 1 + s.charAt(i) - 'A';
            soln = soln + (mult * c);
            mult = mult * 26;
        }
        return soln;
    }
}
