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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode d1 = new ListNode(-1);
        ListNode curr = d1;
        // 1, 2, 3, 4
        // 1, 4, 5, 9, 9, 9, 9
        while(l1 != null || l2 != null) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            int rem = sum % 10;
            curr.next = new ListNode(rem);
            carry = sum / 10;
            curr = curr.next;
        }
  
        if(carry == 1) {
            curr.next = new ListNode(1);
            curr = curr.next;
        }

        return d1.next;
    }
}