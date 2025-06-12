class Solution {
    public int longestOnes(int[] nums, int k) {
        int flips = 0;
        int i = 0;
        int len = nums.length;
        int ans = 0;

        for (int j = 0; j < len; j++) {
            if (nums[j] == 0) {
                flips++;
            }

            // Shrink window if flips exceed k
            while (flips > k) {
                if (nums[i] == 0) {
                    flips--;
                }
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}
