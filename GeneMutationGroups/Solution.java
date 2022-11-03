/*
 * binarysearch.com :: Gene Mutation Groups
 * jramaswami
 */


public class Solution {

    private class UnionFind {
        private int[] parent;
        private int[] size;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            size = new int[n];
            this.count = n;
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
                this.count--;
            }
        }

        public int getCount() {
            return this.count;
        }
    }


    private boolean singleMutation(String a, String b) {
        int delta = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                delta++;
                if (delta > 1) {
                    return false;
                }
            }
        }
        return delta == 1;
    }


    public int solve(String[] genes) {
        UnionFind uf = new UnionFind(genes.length);
        for (int i = 0; i < genes.length; i++) {
            for (int j = i + 1; j < genes.length; j++) {
                if (singleMutation(genes[i], genes[j])) {
                    uf.unionSet(i, j);
                }
            }
        }
        return uf.getCount();
    }
}
