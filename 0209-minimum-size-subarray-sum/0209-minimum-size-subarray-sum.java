class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = nums.length;
        int ss = Integer.MAX_VALUE;
        int left = 0;
        int ts = 0;
        int right = 0;
            
        while(right < l){
            ts = ts + nums[right];
                while(ts >= target){
                    ss = Math.min(ss,right-left+1);
                    ts = ts - nums[left];
                    left++;
                }
            right++;
        }
        
        if(ss==Integer.MAX_VALUE){
            return 0;
        }
        return ss;
    }
}