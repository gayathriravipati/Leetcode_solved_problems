class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0;
        
        for(int n : nums){
            maxHeap.add(n);
        }
        
        while(k > 0){
            int val = maxHeap.poll();
            total += val;
            val = (int) Math.ceil((double) val / 3);
            maxHeap.add(val);
            k--;
        }
        return total;
    }
}