class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //num : frequency
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freq.entrySet());
        int[] res = new int[k];
        
        for(int i=0; i<k; i++){
            Map.Entry<Integer, Integer> top = maxHeap.poll();
            res[i] = top.getKey();
        }

        return res;
    }
}