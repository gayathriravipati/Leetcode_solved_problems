class Solution {
    public boolean canJump(int[] nums) {
        //last idx = 0;
        //target = last_idx
        //target - i Th target target - i
        // if(nums.length == 1){
        //     return true;
        // }
        
       int target = nums.length-1;
        for(int i = nums.length-2; i>=0; i--){
            if(nums[i] + i >= target){
                target = i;
            }
        }
        
        return target == 0 ? true : false;
    
    }
}