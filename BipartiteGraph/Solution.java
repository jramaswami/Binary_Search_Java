/* binarysearch.com :: Bipartite Graph
 * jramaswami
 */

import java.util.LinkedList;


public class Solution {

    private static final int WHITE = 0;
    private static final int RED = 1;
    private static final int BLUE = 2;

    /**
     * Return the opposite of currColor.
     */
    private int otherColor(int currColor) {
        if (currColor == RED) {
            return BLUE;
        } else {
            return RED;
        }
    }

    /**
     * Return true if the graph rooted at src is bipartite.
     */
    private boolean isBipartite(int src, int[][] adj, int[] color) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.addLast(src);
        color[src] = RED;

        while (!queue.isEmpty()) {
            int u = queue.removeFirst();
            int nextColor = otherColor(color[u]);
            for (int v : adj[u]) {
                if (color[v] == WHITE) {
                    color[v] = nextColor;
                    queue.addLast(v);
                } else if (color[v] == color[u]) {
                    // Adjacent nodes cannot be the same color in a bipartite
                    // graph.
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Return true if graph is bipartite.
     */
    public boolean solve(int[][] adj) {
        int[] color = new int[adj.length];

        for (int i = 0; i < adj.length; i++) {
            if (color[i] == WHITE) {
                if (!isBipartite(i, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }

}
