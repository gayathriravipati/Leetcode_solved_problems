class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> freqCount = new HashMap<>();
        for(int n : nums){
            freqCount.put(n, freqCount.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
            Integer value = entry.getValue();
            if(value % 2 != 0){
                return false;
            }
        }
        return true;
    }
}