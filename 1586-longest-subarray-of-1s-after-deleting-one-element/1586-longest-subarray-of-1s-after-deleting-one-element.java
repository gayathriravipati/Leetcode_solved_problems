class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int i = 0;   
        int del = 0; 

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                del++;
            }

            while (del > 1) {
                if (nums[i] == 0) {
                    del--;
                }
                i++;
            }

            ans = Math.max(ans, j - i);
        }

        return ans;
    }
}
