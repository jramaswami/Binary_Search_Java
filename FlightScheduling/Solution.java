// binarysearch.com :: Flight Scheduling
// jramaswami

import java.util.Arrays;

class Solution {

    private class Delta implements Comparable<Delta> {
        int delta;
        int index;

        public Delta(int d, int i) {
            delta = d;
            index = i;
        }

        public int compareTo(Delta other) {
            return Integer.compare(this.delta, other.delta);
        }
    }

    public int solve(int[][] costs) {
        // Compute the extra cost for sending to B.
        Delta[] deltas = new Delta[costs.length];
        for (int i = 0; i < costs.length; i++) {
            int costToA = costs[i][0];
            int costToB = costs[i][1];
            deltas[i] = new Delta(costToB - costToA, i);
        }
        // To minimize the extra cost of sending people to B,
        // prioritize the minimum deltas to B.
        Arrays.sort(deltas);

        // Now sum the cost; the first half to A, the second to B;
        int mid = costs.length / 2;
        int total = 0;
        for (int i = 0; i < deltas.length; i++) {
            int personIndex = deltas[i].index;
            if (i >= mid) {
                // System.out.println("<- (" + personIndex + ") " + Arrays.toString(costs[personIndex]));
                total += costs[personIndex][0];
            } else {
                // System.out.println("-> (" + personIndex + ") " + Arrays.toString(costs[personIndex]));
                total += costs[personIndex][1];
            }
        }
        return total;
    }
}
