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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode cur = head;
        int n = 1;

        while (cur.next != null) {
            cur = cur.next;
            n++;
        }

        cur.next = head;

        k %= n;
        int step = n - k;

        while (step-- > 0) cur = cur.next;

        ListNode res = cur.next;
        cur.next = null;

        return res;
    }
}