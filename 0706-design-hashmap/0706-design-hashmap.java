class MyHashMap {
    
    ListNode[] map;
    
    public MyHashMap() {
        map = new ListNode[1000];
    }
    
    public int hashKey(int key){
        int idx = key % 1000;
        return idx;
    }
    
    public void put(int key, int value) {
        int idx = hashKey(key);
        if(map[idx] == null){
            map[idx] = new ListNode(-1, -1);
        }
        
        ListNode node = findNode(map[idx], key);
        if(node.next == null){
            node.next = new ListNode(key, value);
        }
        node.next.val = value;
    }
    
    public int get(int key) {
        int idx = hashKey(key);
        if(map[idx] == null){
            return -1;
        }
         ListNode node = findNode(map[idx], key);
         if(node.next == null){
             return -1;
         }
         return node.next.val;
    }
    
    public void remove(int key) {
        int idx = hashKey(key);
        if (map[idx] == null) {
            return;
        }
        ListNode node = findNode(map[idx], key);
        if(node.next != null){
            node.next = node.next.next;
        }
    }
    
    public ListNode findNode(ListNode bucket, int key){
        ListNode current = bucket;
        ListNode prev = null;
        
        while(current != null && current.key != key){
            prev = current;
            current = current.next;
        }
        return prev; //either prev.next will be null or prev.next.val will be the key
    }
}

class ListNode{
    int key;
    int val;
    ListNode next;
    
    public ListNode(int key, int val){
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