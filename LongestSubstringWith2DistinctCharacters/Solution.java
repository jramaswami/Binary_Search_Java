/* binarysearch.com :: Longest Substring with 2 Distinct Characters
 * jramaswami
 */

import java.util.HashMap;
import java.util.LinkedList;

class Solution {

    private class Frequencies {
        private HashMap<Character, Integer> freqs;
        private int unique;

        Frequencies() {
            freqs = new HashMap<Character, Integer>();
        }

        public void put(Character c) {
            int prev = freqs.getOrDefault(c, 0);
            freqs.put(c, 1 + prev);
            if (prev == 0) {
                // added a character
                unique++;
            }
        }

        public void remove(Character c) {
            freqs.put(c, freqs.get(c) - 1);
            if (freqs.get(c) == 0) {
                // Removed the last of this character.
                unique--;
            }
        }

        public int getFrequency(Character c) {
            return freqs.get(c);
        }

        public int uniqueCount() {
            return unique;
        }
    }

    public int solve(String s) {
        Frequencies freqs = new Frequencies();
        int soln = 0;
        LinkedList<Character> deque = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            freqs.put(c);
            deque.offerLast(c);
            while (freqs.uniqueCount() > 2) {
                Character r = deque.pollFirst();
                freqs.remove(r);
            }
            soln = Math.max(soln, deque.size());
        }
        return soln;
    }
}
