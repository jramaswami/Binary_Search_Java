/* binarysearch.com :: Connect Cartesian Coordinates
 * jramaswami
 */

import java.util.Arrays;

class Solution {
    private class UnionFind {
        int[] parent;
        int[] size;
        int count;

        UnionFind(int N) {
            parent = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            count = N;
        }

        public int findSet(int u) {
            if (parent[u] == u) {
                return u;
            }
            int p = findSet(parent[u]);
            parent[u] = p;
            return p;
        }

        public void unionSet(int a, int b) {
            a = findSet(a);
            b = findSet(b);
            if (a != b) {
                if (size[a] < size[b]) {
                    int t = a;
                    a = b;
                    b = t;
                }
                parent[b] = a;
                size[a] += size[b];
            }
        }

    }

    private class Edge implements Comparable<Edge> {
        int left;
        int right;
        int weight;

        public Edge(int u, int v, int w) {
            left = u;
            right = v;
            weight = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public int solve(int[][] points) {
        UnionFind uf = new UnionFind(points.length);
        int N = (points.length * (points.length-1)) / 2;
        Edge edges[] = new Edge[N];
        int e = 0;
        for (int u = 0; u < points.length; u++) {
            int x0 = points[u][0];
            int y0 = points[u][1];
            for (int v = u + 1; v < points.length; v++) {
                int x1 = points[v][0];
                int y1 = points[v][1];
                int weight = Math.abs(x0 - x1) + Math.abs(y0 - y1);
                Edge edge = new Edge(u, v, weight);
                edges[e] = edge;
                e++;
            }
        }

        // Sort edges by weight.
        Arrays.sort(edges);

        int minWeight = 0;
        for (Edge edge : edges) {
            int u = uf.findSet(edge.left);
            int v = uf.findSet(edge.right);
            if (u != v) {
                uf.unionSet(u, v);
                minWeight += edge.weight;
            }
        }
        return minWeight;
    }
}
