class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Let's take min-heap and remove top element whenever size exceeds k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int n : nums){
           minHeap.add(n);
           if(minHeap.size() > k){
                minHeap.poll();
           } 
        }
        return minHeap.peek();
    }
}