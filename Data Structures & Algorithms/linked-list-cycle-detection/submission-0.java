/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null ) return false;

        var f = head.next;
        var s = head;

        while (s != null) {
            if (f.equals(s)) {
                return true;
            }
            
            if (f.next == null || f.next.next == null) {
                return false;
            } 

            f = f.next.next;
            s = s.next;
        }

        return false;
    }
}
