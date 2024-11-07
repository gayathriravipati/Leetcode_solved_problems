class LRUCache {
    int capacity;
    Map<Integer, ListNode> dic;
    ListNode head;
    ListNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        dic = new HashMap<>();
       
    }
    
    public int get(int key) {
        if(!dic.containsKey(key)){
            return -1;
        }
        
        ListNode node = dic.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(dic.containsKey(key)){
            ListNode node = dic.get(key);
            removeNode(node);
        }
        
        ListNode newNode = new ListNode(key, value);
        addNode(newNode);
        dic.put(key, newNode);
        
        if(dic.size() > capacity){
            ListNode toDelete = head.next;
            removeNode(toDelete);
            dic.remove(toDelete.key); 
        }
    }
    
    public void removeNode(ListNode node){
        ListNode nextNode = node.next;
        ListNode prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public void addNode(ListNode newNode){
        ListNode prevEnd = tail.prev;
        prevEnd.next = newNode;
        newNode.prev = prevEnd;
        newNode.next = tail;
        tail.prev = newNode;
        prevEnd = newNode;
    }
    
}

class ListNode{
    int key;
    int val;
    ListNode next;
    ListNode prev;
    
    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */