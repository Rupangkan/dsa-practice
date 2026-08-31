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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int min = Integer.MAX_VALUE;
        int first = -1;
        int prev = -1;
        int index = 1;

        ListNode left = head;
        ListNode curr = head.next;

        while (curr != null && curr.next != null) {
            int val = curr.val;

            if ((val > left.val && val > curr.next.val) ||
                (val < left.val && val < curr.next.val)) {

                if (first == -1) {
                    first = index;
                } else {
                    min = Math.min(min, index - prev);
                }

                prev = index;
            }

            left = curr;
            curr = curr.next;
            index++;
        }

        if (first == -1 || first == prev) {
            return new int[] { -1, -1 };
        }

        return new int[] { min, prev - first };
    }
}