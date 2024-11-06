class Solution {
    public int minStartValue(int[] nums) {
        int minVal = 1;
        int ps = 0;
        
        for(int i=0; i<nums.length; i++){
            ps += nums[i];
            
            minVal = Math.min(ps, minVal);
        }

        if(minVal <= 0){
            minVal = Math.abs(minVal) + 1;
        }
        
        return minVal;
    }
}