class Solution {
    public int maxProduct(int[] nums) {
        int cn = nums[0];
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int prevMax = max;
            int prevMin = min;
            cn = nums[i];
            max = Math.max(cn, Math.max(prevMax * cn, prevMin * cn));
            min = Math.min(cn, Math.min(prevMax * cn, prevMin * cn));
            res = Math.max(res, max);
        }
        return res;
    }
}