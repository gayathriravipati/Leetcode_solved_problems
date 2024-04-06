class ListNode{
    ListNode next;
    ListNode prev;
    int key;
    int val;
    
    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, ListNode> mp;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mp = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        }
        ListNode node = mp.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            ListNode oldNode = mp.get(key);
            remove(oldNode);
        }
        
        ListNode node = new ListNode(key, value);
        mp.put(key, node);
        add(node);
        
        if (mp.size() > capacity) {
            ListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            mp.remove(nodeToDelete.key);
        }
    }
    
    public void add(ListNode node){
        ListNode prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
    
    public void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */