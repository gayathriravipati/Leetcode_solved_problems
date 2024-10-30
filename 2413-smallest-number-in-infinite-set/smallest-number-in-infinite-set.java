class SmallestInfiniteSet {
    
    PriorityQueue<Integer> minHeap;
    HashSet<Integer> uniqueElements;
    int i;
    
    public SmallestInfiniteSet() {
        i = 1;
        minHeap = new PriorityQueue<>();
        uniqueElements = new HashSet<>();
    }
    
    public int popSmallest() {
        
        if(minHeap.size() != 0){
            uniqueElements.remove(minHeap.peek());
            return minHeap.poll();
        }
        else{
            i++;
            return i-1;
        }
    }
    
    public void addBack(int num) {
        if(i > num && !uniqueElements.contains(num)){
           minHeap.add(num); 
           uniqueElements.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */