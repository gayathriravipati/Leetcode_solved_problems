class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for(int i = 1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], nums[i-1]);
            rightMax[n-i-1] = Math.max(rightMax[n-i], nums[n-i]);
        }

        for(int i=1; i<n-1; i++){
            res = Math.max(res, (long) (leftMax[i] - nums[i]) * rightMax[i]);
        }

        return res;
    }
}