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
    public Node better(Node head) {
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

    private Node optimal(Node head) {
        Node temp = head;
        while(temp != null) {
            Node currNode = new Node(temp.val);
            currNode.next = temp.next;
            temp.next = currNode;
            temp = temp.next.next;
        }

        temp = head;

        while(temp != null) {
            Node currNode = temp.next;
            if(temp.random != null)
                currNode.random = temp.random.next;
            else 
                currNode.random = null;
            temp = temp.next.next;
        }

        temp = head;
        Node d1 = new Node(-1);
        Node res = d1;

        while(temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return d1.next;
    }

    public Node copyRandomList(Node head) {
        return optimal(head);
    }
}