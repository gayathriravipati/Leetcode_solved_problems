class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        int maxLen = 0;
        for(int k : freq.keySet()){
            if(freq.containsKey(k+1)){
                maxLen = Math.max(maxLen, freq.get(k) + freq.getOrDefault(k+1, 0));
            }
        }

        return maxLen;
    }
}