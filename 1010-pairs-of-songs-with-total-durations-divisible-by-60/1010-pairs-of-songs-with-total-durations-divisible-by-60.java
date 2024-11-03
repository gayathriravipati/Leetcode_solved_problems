class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> remFreq = new HashMap<>();
        int pairs = 0;
        
        for(int i : time){
            int rem = i % 60;
            int comp = rem==0 ? 0 : 60 - rem;
            pairs += remFreq.getOrDefault(comp, 0);
            remFreq.put(rem, remFreq.getOrDefault(rem,0) + 1);
        }
        return pairs;
    }
}