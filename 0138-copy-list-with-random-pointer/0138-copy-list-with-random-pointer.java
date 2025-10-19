/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;

        while(temp != null) {
            Node curr = new Node(temp.val);
            curr.next = temp.next;
            temp.next = curr;
            temp = temp.next.next;
        }

        temp = head;

        while(temp != null && temp.next != null) {
            Node curr = temp.next;
            if(temp.random != null) {
                curr.random = temp.random.next;
            } else {
                curr.random = null;
            }
            temp = temp.next.next;
        }

        temp = head;
        Node d1 = new Node(-1);
        Node d2 = d1;

        while(temp != null && temp.next != null) {
            d2.next = temp.next;
            d2 = d2.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }   

        return d1.next;
    }
}