/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode a = head1;
        ListNode b = head2;
    
        if(a == null || b == null) return null;

        while(a != b) {
            a = a == null ? head2 : a.next;
            b = b == null ? head1 : b.next;
        }

        return a;
    }
}