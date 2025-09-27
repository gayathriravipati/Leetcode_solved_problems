class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
         
        if(len == 1){
            return nums[0];
        }

        if(len == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] robbedAmount = new int[len + 1];
        robbedAmount[len-1] = nums[len-1];

        for(int i = len-2; i >=0; i--){
            robbedAmount[i] = Math.max(robbedAmount[i+2] + nums[i], robbedAmount[i+1]);
        }

        return robbedAmount[0];
    }
}