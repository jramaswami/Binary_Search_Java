/* binarysearch.com :: Spiral Matrix
 * jramaswami
 */

class Solution {

    private int[][] matrix;
    private boolean[][] visited;
    private int[] soln;


    private class Dirn {
        private static final int RIGHT = 0;
        private static final int DOWN = 1;
        private static final int LEFT = 2;
        private static final int UP = 3;

        private int dirn;
        public Dirn() {
            this.dirn = RIGHT;
        }

        public void turn() {
            this.dirn = (this.dirn + 1) % 4;
        }

        public Posn getOffset() {
            switch (this.dirn) {
                case RIGHT:
                    return new Posn(0, 1);
                case DOWN:
                    return new Posn(1, 0);
                case LEFT:
                    return new Posn(0, -1);
                case UP:
                    return new Posn(-1, 0);
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this.dirn) {
                case RIGHT:
                    return "Right";
                case DOWN:
                    return "Down";
                case LEFT:
                    return "Left";
                case UP:
                    return "Up";
            }
            return null;
        }
    }

    private boolean isInbounds(Posn p) {
        return (p.row >= 0 && p.col >= 0 &&
                p.row < matrix.length && p.col < matrix[0].length);
    }

    private boolean isVisited(Posn p) {
        return visited[p.row][p.col];
    }

    private void visitPosn(Posn p) {
        visited[p.row][p.col] = true;
    }


    private class Posn {
        int row;
        int col;

        Posn(int r, int c) {
            row = r;
            col = c;
        }

        public Posn move(Dirn dirn) {
            Posn off = dirn.getOffset();
            Posn p0 = new Posn(this.row + off.row, this.col + off.col);
            int turns = 0;
            while ((!isInbounds(p0)) || isVisited(p0)) {
                dirn.turn();
                off = dirn.getOffset();
                p0 = new Posn(this.row + off.row, this.col + off.col);
                turns++;
                if (turns >= 4) {
                    return null;
                }
            }
            return p0;
        }

        @Override
        public boolean equals (Object o) {
            if (o == this) { return true; }
            if (! (o instanceof Posn)) { return false; }
            Posn p0 = (Posn)o;
            return (p0.row == this.row && p0.col == this.col);
        }

        @Override
        public String toString() {
            return "(" + this.row + ", " + this.col + ")";
        }
    }

    public int[] solve(int[][] matrix) {
        // Corner cases:
        if (matrix.length == 0) {
            return new int[0];
        }

        if (matrix[0].length == 0) {
            return new int[0];
        }

        int N = matrix.length * matrix[0].length;
        this.matrix = matrix;
        this.soln = new int[N];
        this.visited = new boolean[matrix.length][matrix[0].length];
        Posn currPosn = new Posn(0, 0);
        Dirn dirn = new Dirn();
        this.soln[0] = matrix[currPosn.row][currPosn.col];
        for (int i = 1; i < N; i++) {
            visitPosn(currPosn);
            currPosn = currPosn.move(dirn);
            if (currPosn == null) {
                break;
            }
            this.soln[i] = matrix[currPosn.row][currPosn.col];
        }
        return this.soln;
    }
}
