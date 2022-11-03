/* binarysearch.com :: Intersecting Lines
 * jramaswami
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Solution {

    private class EndPoint implements Comparable<EndPoint> {
        int leftY, rightY, id;

        EndPoint(int _ly, int _ry, int _id) {
            leftY = _ly;
            rightY = _ry;
            id = _id;
        }

        @Override
        public int compareTo(EndPoint other) {
            return Integer.compare(leftY, other.leftY);
        }
    }

    private class EndPointTree {
        TreeMap<Integer, Integer> tree;

        EndPointTree() {
            tree = new TreeMap<Integer, Integer>();
        }

        void increment(int key) {
            if (tree.containsKey(key)) {
                tree.put(key, tree.get(key) + 1);
            } else {
                tree.put(key, 1);
            }
        }

        void decrement(int key) {
            int val = tree.get(key);
            if (val == 1) {
                tree.remove(key);
            } else {
                tree.put(key, val - 1);
            }
        }

        Integer get(int key) {
            if (tree.containsKey(key)) {
                return tree.get(key);
            }
            return 0;
        }

        Integer higherKey(int key) {
            return tree.higherKey(key);
        }

        Integer lowerKey(int key) {
            return tree.lowerKey(key);
        }
    }

    public int solve(int[][] lines, int lo, int hi) {
        int N = lines.length;
        // Convert each line into a line segment from x=lo and x=hi. Record
        // each left and right end point.
        ArrayList<EndPoint> leftEndPoints = new ArrayList<EndPoint>(N);
        EndPointTree rightAbove = new EndPointTree();
        EndPointTree rightBelow = new EndPointTree();

        for (int i = 0; i < N; ++i) {
            int slope = lines[i][0];
            int constant = lines[i][1];
            int leftY = (slope * lo) + constant;
            int rightY = (slope * hi) + constant;
            leftEndPoints.add(new EndPoint(leftY, rightY, i));
            rightAbove.increment(rightY);
        }

        Collections.sort(leftEndPoints);
        boolean[] intersects = new boolean[N];

        int soln = 0;
        for (int i = 0; i < N; ++i) {
            EndPoint left = leftEndPoints.get(i);
            int leftY = left.leftY;
            int rightY = left.rightY;
            int slope = lines[left.id][0];
            boolean hasIntersection = false;

            // Does line intersect on left with previous line?
            if (i > 0) {
                if (leftEndPoints.get(i-1).leftY == leftY) {
                    hasIntersection = true;
                }
            }

            // Does line intersect on left with next line?
            if (i + 1 < N) {
                if (leftEndPoints.get(i+1).leftY == leftY) {
                    hasIntersection = true;
                }
            }

            // Does line intersect with any lines on the right?
            if (rightAbove.get(rightY) + rightBelow.get(rightY) > 1) {
                hasIntersection = true;
            }

            if (!hasIntersection) {
                // Does the line cross any others during the x interval?
                if (slope >= 0) {
                    // Postive slope or vertical line.
                    // Do any of the lines above this one have a rightY below
                    // the current leftY?
                    Integer lk = rightAbove.lowerKey(rightY);
                    if (lk != null) {
                        hasIntersection = true;
                    }
                    // Do any of the lines below this one have a rightY above
                    // the current leftY?
                    Integer hk = rightBelow.higherKey(rightY);
                    if (hk != null) {
                        hasIntersection = true;
                    }

                } else {
                    // Negative slope
                    // Do any of the lines below this one have a rightY above
                    // the current leftY?
                    Integer hk = rightBelow.higherKey(rightY);
                    if (hk != null) {
                        hasIntersection = true;
                    }
                    // Do any of the lines above this one have a rightY below
                    // the current leftY?
                    Integer lk = rightAbove.lowerKey(rightY);
                    if (lk != null) {
                        hasIntersection = true;
                    }
                }
            }

            if (hasIntersection) soln++;
            rightAbove.decrement(rightY);
            rightBelow.increment(rightY);
        }
        return soln;
    }
}
