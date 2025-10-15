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
        Node d1 = new Node(-1);
        Node temp = d1;
        Node tempHead = head;
        HashMap<Node, Node> map = new HashMap<>();

        while(tempHead != null) {
            temp.next = new Node(tempHead.val);
            map.put(tempHead, temp.next);
            temp = temp.next;
            tempHead = tempHead.next;
        }

        temp = d1.next;
        tempHead = head;
        while(tempHead != null) {
            temp.random = map.get(tempHead.random);
            tempHead = tempHead.next;
            temp = temp.next;
        }

        return d1.next;
        
    }
}