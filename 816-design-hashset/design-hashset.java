class MyHashSet {
    private HashSet<Integer> hashSet;
    
    public MyHashSet() {
        this.hashSet = new HashSet<>();
    }
    
    public void add(int key) {
        hashSet.add(key);
    }
    
    public void remove(int key) {
        if(hashSet.contains(key)){
            hashSet.remove(key);
        }
    }
    
    public boolean contains(int key) {
        if(hashSet.contains(key)){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */