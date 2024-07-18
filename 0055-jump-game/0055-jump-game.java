class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        int length = nums.length;
        for(int i = length - 2; i>=0; i--){
            if(nums[i] + i >= target){
                target = i;
            }
        }
        if(target == 0){
            return true;
        }
      return false;   
    }
}