class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int oob = -1;
        int min_idx = -1;
        int max_idx = -1;
        long ans = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==minK){
                min_idx = i;
            }
            
            if(nums[i]==maxK){
                max_idx = i;
            }
            
            if(nums[i] > maxK ||nums[i]  < minK ){
                oob = i;
            }
            
            ans += Math.max(0, Math.min(min_idx,max_idx) - oob);
            
        }
        return ans;
    }
}