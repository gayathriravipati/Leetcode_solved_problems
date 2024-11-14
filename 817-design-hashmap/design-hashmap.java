class MyHashMap {

    // Initialize the map with an array of ListNode
    private ListNode[] map;
    
    public MyHashMap() {
        map = new ListNode[1000];
    }
    
    // Hash function to map a key to an index
    private int hash(int key) {
        return key % map.length;
    }
    
    // Method to put a key-value pair in the map
    public void put(int key, int value) {
        int index = hash(key);
        
        if (map[index] == null) {
            map[index] = new ListNode(-1, -1); // Dummy node
        }
        
        ListNode prev = findNode(map[index], key);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    // Method to get the value of a key
    public int get(int key) {
        int index = hash(key);
        if (map[index] == null) {
            return -1;
        }
        
        ListNode prev = findNode(map[index], key);
        return prev.next == null ? -1 : prev.next.val;
    }
    
    // Method to remove a key from the map
    public void remove(int key) {
        int index = hash(key);
        if (map[index] == null) {
            return;
        }
        
        ListNode prev = findNode(map[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }
    
    private ListNode findNode(ListNode bucket, int key) {
        ListNode node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
}

class ListNode {
        int key, val;
        ListNode next;
        
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */