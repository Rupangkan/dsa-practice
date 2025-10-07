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
    public ListNode middleNode(ListNode head) {
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
}