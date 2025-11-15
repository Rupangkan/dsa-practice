class Node {
    int key;
    int value;
    int count;
    Node next, prev;

    Node(int k, int v) {
        key = k;
        value = v;
        count = 1;
    }
}

class DLLList {
    int size;
    Node head, tail;

    DLLList() {
        size = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;

        tail.prev = head;
    }

    void addFront(Node node) {
        Node temp = head.next;
        node.next = temp;
        node.prev = head;
        head.next = node;
        temp.prev = node;
        size++;
    }

    void removeBack(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }
}

class LFUCache {
    Map<Integer, DLLList> freqNode;
    Map<Integer, Node> keyNode;
    int capacity, leastFreq, currSize;

    public LFUCache(int c) {
        freqNode = new HashMap<>();
        keyNode = new HashMap<>();
        capacity = c;
        currSize = 0;
        leastFreq = 0;
    }
    
    public int get(int key) {
        if(!keyNode.containsKey(key)) return -1;
        Node current = keyNode.get(key);
        updateFreqMap(current);
        return current.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(keyNode.containsKey(key)) {
            Node current = keyNode.get(key);
            current.value = value;
            updateFreqMap(current);
        } else {
            if(currSize == capacity) {
                DLLList currList = freqNode.get(leastFreq);
                keyNode.remove(currList.tail.prev.key);
                freqNode.get(leastFreq).removeBack(currList.tail.prev);
                currSize--;
            }
            currSize++;
            leastFreq = 1;
            
            DLLList minFreqList = new DLLList();
            if(freqNode.containsKey(leastFreq)) {
                minFreqList = freqNode.get(leastFreq);
            }
            Node newNode = new Node(key, value);
            minFreqList.addFront(newNode);
            keyNode.put(key, newNode);
            freqNode.put(leastFreq, minFreqList);
        }
    }

    void updateFreqMap(Node node) {
        keyNode.remove(node.key);
        freqNode.get(node.count).removeBack(node);
        
        if(node.count == leastFreq && freqNode.get(node.count).size == 0) {
            leastFreq++;
        }

        DLLList nextHigherFreq = new DLLList();
        if(freqNode.containsKey(node.count+1)) {
            nextHigherFreq = freqNode.get(node.count+1);
        }
        node.count += 1;

        nextHigherFreq.addFront(node);
        freqNode.put(node.count, nextHigherFreq);
        keyNode.put(node.key, node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */