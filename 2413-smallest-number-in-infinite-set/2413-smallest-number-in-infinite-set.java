class SmallestInfiniteSet {
    int currentValue;
    Set<Integer> isPresent;
    PriorityQueue<Integer> minElement;

    public SmallestInfiniteSet() {
        currentValue = 1;
        isPresent = new HashSet<>();
        minElement = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        int ans = 0;
        if(minElement.size() > 0){
            ans = minElement.poll();
            isPresent.remove(ans);
        }
        else{
            ans = currentValue;
            currentValue++;
        }
        return ans;
    }
    
    public void addBack(int num) {
        if(currentValue <= num || isPresent.contains(num)){
            return;
        }
        isPresent.add(num);
        minElement.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */