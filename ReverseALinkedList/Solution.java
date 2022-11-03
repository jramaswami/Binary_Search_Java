/* binarysearch.com :: Reverse a Linked List
 * jramaswami
 */

import com.binarysearch.LLNode;

class Solution {

    public LLNode solve(LLNode node) {
        LLNode newHead = null;
        LLNode prev = null;
        LLNode curr = node;
        LLNode follow = node;
        while(curr != null) {
            newHead = curr;
            follow = curr.next;
            curr.next = prev;
            prev = curr;
            curr = follow;
        }
        return newHead;
    }
}
