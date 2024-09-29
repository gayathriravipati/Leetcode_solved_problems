class Node{
    Node prev;
    Node next;
    Set<String> keys = new HashSet<>();
    int freq;
    
     Node(int freq) {
        this.freq = freq;
    }
}

class AllOne {
    Node head;
    Node tail;
    Map<String, Node> freqMap = new HashMap<>();

    
    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        if(freqMap.containsKey(key)){
            Node currNode = freqMap.get(key);
            int currVal = currNode.freq;
            currNode.keys.remove(key);
             Node nextNode = currNode.next;
             if (nextNode == tail || nextNode.freq != currVal + 1) {
                  Node newNode = new Node(currVal + 1);
                  newNode.keys.add(key);
                  newNode.prev = currNode;
                  currNode.next = newNode;
                  nextNode.prev = newNode;
                  newNode.next = nextNode;
                  freqMap.put(key, newNode);
             } else {
                nextNode.keys.add(key);
                freqMap.put(key, nextNode);
            }
            if (currNode.keys.isEmpty()) {
                removeNode(currNode);
            }
        }
        else{
            //insert next to head where freq == 1;
            Node firstNode = head.next;
            if (firstNode == tail || firstNode.freq > 1) {
                Node newNode = new Node(1);
                newNode.keys.add(key);
                newNode.prev = head;
                newNode.next = firstNode;
                head.next = newNode;
                firstNode.prev = newNode;
                freqMap.put(key, newNode);
            } else {
                firstNode.keys.add(key);
                freqMap.put(key, firstNode);
            }
        }
    }
    
    public void dec(String key) {
        if (!freqMap.containsKey(key)) {
            return;
        }
        
        Node node = freqMap.get(key);
        node.keys.remove(key);
        int freq = node.freq;

        if (freq == 1) {
            freqMap.remove(key);
        }else {
            Node prevNode = node.prev;
            if (prevNode == head || prevNode.freq != freq - 1) {
                Node newNode = new Node(freq - 1);
                newNode.keys.add(key);
                newNode.prev = prevNode;
                newNode.next = node;
                prevNode.next = newNode;
                node.prev = newNode;
                freqMap.put(key, newNode);
            } else {
                prevNode.keys.add(key);
                freqMap.put(key, prevNode);
            }
        }
        if (node.keys.isEmpty()) {
            removeNode(node);
        }
    }
    
    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }
    
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */