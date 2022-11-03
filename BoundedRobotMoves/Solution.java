/* binarysearch.com :: Bounded Robot Moves
 * jramaswami
 */

class Solution {

    private class Robot {
        private final int NORTH = 0;
        private final int EAST = 1;
        private final int SOUTH = 2;
        private final int WEST = 3;

        private final int[][] OFFSETS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        private int x;
        private int y;
        private int dirn;

        public Robot() {
            this.x = 0;
            this.y = 0;
            this.dirn = NORTH;
        }

        public void forward() {
            this.x += OFFSETS[dirn][0];
            this.y += OFFSETS[dirn][1];
        }

        public void forward(int delta) {
            this.x += (delta * OFFSETS[dirn][0]);
            this.y += (delta * OFFSETS[dirn][1]);
        }

        public void lateral(int delta) {
            if (delta < 0) {
                turnLeft();
            } else if (delta > 0) {
                turnRight();
            }
            forward(delta);
        }

        public void turnLeft() {
            dirn--;
            if (dirn < 0) {
                dirn = WEST;
            }
        }

        public void turnRight() {
            dirn++;
            if (dirn > WEST) {
                dirn = NORTH;
            }
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getDirn() {
            return this.dirn;
        }
    }

    public boolean solve(String s) {
        /* Move robot through one cycle of the instructions. */
        Robot robot = new Robot();
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case 'F':
                        robot.forward();
                        break;
                    case 'L':
                        robot.turnLeft();
                        break;
                    case 'R':
                        robot.turnRight();
                        break;
                }
            }
            if (robot.getX() == 0 && robot.getY() == 0) {
                return true;
            }
        }
        return false;
    }
}
