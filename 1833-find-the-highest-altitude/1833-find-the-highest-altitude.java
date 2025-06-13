class Solution {
    public int largestAltitude(int[] gain) {
        int maxGain = 0;
        int sum = 0;

        for(int g : gain){
            sum += g;
            maxGain = Math.max(sum, maxGain);
        }

        return maxGain;
    }
}