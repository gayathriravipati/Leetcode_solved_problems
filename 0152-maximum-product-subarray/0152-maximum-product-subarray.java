class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int cn = nums[0];
        int res = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            int prev_max = max;
            int prev_min = min;
            cn = nums[i];
            max = Math.max(cn, Math.max(nums[i] * prev_max, nums[i] * prev_min));
            min = Math.min(cn, Math.min(nums[i] * prev_max, nums[i] * prev_min));
            res = Math.max(res, max);
            prev_max = max;
            prev_min = min;
        }
        return res;
    }
}