class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxe = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] > maxe){
                maxe = nums[i];
            }
        }
        
        int left = 0;
        int tc = 0;
        long ts = 0;
        int len = nums.length;
        
        for(int right = 0;right<nums.length; right++){
            if(nums[right] == maxe){
                tc++;
            }
            
            if(tc == k){
                int c = 0;
                while(c == 0){
                    ts = ts + (len - right);
                    if(nums[left]==maxe){
                        c=1;
                        tc--;
                    }
                    left++;
                }
            }
            
        }
        
        return ts;
    }
}