class MedianFinder {
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;
    
    public MedianFinder() {
        low = new PriorityQueue<>(Collections.reverseOrder());
        high = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        low.add(num);
        high.add(low.poll());
        if(high.size() > low.size()){
            low.add(high.poll());
        }
    }
    
    public double findMedian() {
        if(high.size() == low.size()){
            return (high.peek() + low.peek()) / 2.0;
        }
        else{
            return low.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */