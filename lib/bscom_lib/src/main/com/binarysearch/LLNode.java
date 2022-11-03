/* Linked List Node for binarysearch.com
 */

package com.binarysearch;

public class LLNode {

    public int val;
    public LLNode next;

    public LLNode(int v, LLNode n) {
        val = v;
        next = n;
    }

    public LLNode(int v) {
        val = v;
        next = null;
    }

    @Override
    public String toString() {
        String S = Integer.toString(val);
        if (next != null) {
            return S + " -> " + this.next.toString();
        }
        return S;
    }

    public static LLNode fromArray(int[] array) {
        if (array.length == 0) {
            return null;
        }

        LLNode head = new LLNode(array[0]);
        LLNode curr = head;
        for (int i = 1; i < array.length; i++) {
            LLNode newNode = new LLNode(array[i]);
            curr.next = newNode;
            curr = newNode;
        }
        return head;
    }

    public int length() {
        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.length();
        }
    }

    private static void fill(LLNode node, int index, int[] array) {
        if (node == null) {
            return;
        }
        array[index] = node.val;
        fill(node.next, index + 1, array);
    }

    public static int[] toArray(LLNode head) {
        // Get length.
        int len = head.length();
        int[] array = new int[len];
        fill(head, 0, array);
        return array;
    }
}
