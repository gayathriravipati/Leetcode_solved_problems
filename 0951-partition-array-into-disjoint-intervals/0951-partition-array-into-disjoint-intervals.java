class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] minArray = new int[n];

        minArray[n-1] = nums[n-1];

        for(int i = n-2; i>=0; i--){
            minArray[i] = Math.min(minArray[i+1], nums[i]);
        }

        int currMax = nums[0];

        for(int i = 1; i<n; i++){
            if(currMax <= minArray[i]){
                return i;
            }
            currMax = Math.max(currMax, nums[i]);
        }
        return -1;
    }
}