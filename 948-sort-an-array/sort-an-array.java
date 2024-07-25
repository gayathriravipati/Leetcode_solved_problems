class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
                  minHeap.add(nums[i]);
         }
        
        int i = 0;
        int[] result = new int[nums.length];
        
        while (!minHeap.isEmpty()) {
           nums[i++] = minHeap.poll();
        }
        
        return nums;
    }
}