class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freqCnt = new HashMap<>();
        int values = 0;

        for(int num : nums){
            int diff = k - num;
            if(freqCnt.containsKey(diff)){
                freqCnt.put(diff, freqCnt.get(diff) - 1);
                if(freqCnt.get(diff) == 0){
                    freqCnt.remove(diff);
                }
                values++;
            }
            else{
                freqCnt.put(num, freqCnt.getOrDefault(num, 0) + 1);
            }
        }

        return values;
    }
}