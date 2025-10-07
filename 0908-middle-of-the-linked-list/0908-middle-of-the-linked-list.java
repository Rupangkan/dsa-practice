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

    public ListNode brute(ListNode head) {
        ListNode curr = head;
        int n = 0;

        while(curr != null) {
            curr = curr.next;
            n++;
        }
        curr = head;
        int idx = 0, end = (int)Math.ceil(n/2);

        while(idx < end) {
            curr = curr.next;
            idx++;
        }

        return curr;
    }

    public ListNode optimal(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null && slow != null && slow.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    
    public ListNode middleNode(ListNode head) {
        return optimal(head);
    }
}