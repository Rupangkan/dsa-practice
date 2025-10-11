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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode d1 = new ListNode();
        d1.next = head;
        int count = 0;

        ListNode curr = d1, prev = d1, next = d1;

        while(curr.next != null) {
            curr = curr.next;
            count++;
        }

        while(count >= k) {
            curr = prev.next;
            next = curr.next;

            for(int i = 1; i<k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }
        return d1.next;
    }
}