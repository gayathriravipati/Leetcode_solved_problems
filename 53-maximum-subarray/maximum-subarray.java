class Solution {
    public int maxSubArray(int[] nums) {
        int currentTotal = nums[0];
        int maxTotal = nums[0];
        
        for(int i=1; i<nums.length; i++){
            
            currentTotal = Math.max(nums[i], currentTotal + nums[i]);
            maxTotal = Math.max(maxTotal, currentTotal);
            
        }
        return maxTotal;
    }
}