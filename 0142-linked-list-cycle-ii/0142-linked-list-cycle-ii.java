/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            // if(fast.next == null || fast.next.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                fast = head;
                while(fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
            // slow = slow.next;
            // fast = fast.next.next;
        }

        return null;

        // fast = head;

        // while(slow != fast) {
        //     slow = slow.next;
        //     fast = fast.next;
        // }

        // return slow;
    }
}