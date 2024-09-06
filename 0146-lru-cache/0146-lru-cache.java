class LRUCache {
    Deque<Integer> dq;
    HashMap<Integer, Integer> mapper;
    int capacity;
    public LRUCache(int capacity) {
        dq = new ArrayDeque<>(capacity);
        mapper = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(mapper.containsKey(key)){
            dq.remove(key);
            dq.addLast(key);
            return mapper.get(key);
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if(mapper.containsKey(key)){
            dq.remove(key);
        }
        else{
            if((mapper.size() == capacity)){
                int oldestVal = dq.removeFirst();
                mapper.remove(oldestVal);
            }
        }
        dq.addLast(key);
        mapper.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */