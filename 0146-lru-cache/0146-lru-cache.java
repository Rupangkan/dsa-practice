class Node {
    int key;
    int value;
    Node next;
    Node prev;
    Node(int k, int v) {
        key = k;
        value = v;
    }
}

class LRUCache {

    Map<Integer, Node> map;
    int c;
    Node head, tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        c = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existing = map.get(key);
            existing.value = value;
            deleteNode(existing);
            insertAfterHead(existing);
        } else {
            if (map.size() == c) {
                Node lru = tail.prev;
                deleteNode(lru);
                map.remove(lru.key);
            }

            Node node = new Node(key, value);
            insertAfterHead(node);
            map.put(key, node);
        }
    }

    public void insertAfterHead(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
        
    }

    public void deleteNode(Node node) {
        map.remove(node.key);
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    } 
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */