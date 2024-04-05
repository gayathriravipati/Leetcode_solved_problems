class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int len = nums.length;
        int sl = Integer.MAX_VALUE;
        
        for (int i = 0; i < len; i++) {
            int or = 0;
            for (int j = i; j < len; j++) {
                or |= nums[j];
                if (or >= k) {
                    sl = Math.min(sl, j - i + 1);
                    break;
                }
            }
        }
        
        return sl == Integer.MAX_VALUE ? -1 : sl;
    }
}
