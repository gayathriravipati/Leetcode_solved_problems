class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
         boolean positiveOne = checkArray(nums.clone(), k, 1);
         boolean negativeOne = checkArray(nums.clone(), k, -1);

        return positiveOne || negativeOne;
    }

    private boolean checkArray(int[] nums, int limit, int target){
        int t = 0;
        int len = nums.length;
        for(int i = 0; i < len - 1; i++){
            if(nums[i] != target){
                nums[i] *= -1;
                nums[i+1] *= -1;
                t++;
                if(t > limit){
                    return false;
                }
            }
        }

        return nums[len-1] == target;
    }
}