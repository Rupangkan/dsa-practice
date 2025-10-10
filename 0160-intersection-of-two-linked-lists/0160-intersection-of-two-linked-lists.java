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
    private ListNode better(ListNode headA, ListNode headB) {
        Set<ListNode> st = new HashSet<>();

        while(headA != null) {
            st.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if(st.contains(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }

    private ListNode optimal(ListNode A, ListNode B) {
        ListNode d1 = A, d2 = B;

        if(A == null || B == null) return null;

        while(d1 != d2) {
            d1 = d1 == null ? B: d1.next;
            d2 = d2 == null ? A: d2.next;
        }
        return d1;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return optimal(headA, headB);
    }
}