class Solution {
    public int minimizeMax(int[] nums, int p) {
        //
        // The maximum difference of pair will be the one between largest and smallest number
        // We need to find "p" pairs such that the max diff between any of the pairs is minimum
        // Which means we need not include the pair with first and last element until it doesn't satisfy p.

        // So the range of diff can be from 0 to diff(last - first element)

        // For the taken value, we need to see if there are p pair with that difference.

        //Learnt from Leetcode solution and submissions

        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];

        while(left < right){
            int mid = left + (right - left) / 2;
            if(validPairs(mid, nums) >= p){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    private int validPairs(int target, int[] nums) {
        int total = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= target) {
                total++;
                i += 2; 
            } else {
                i++; 
            }
        }
        return total;
    }
}