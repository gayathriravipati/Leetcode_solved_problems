class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int index, int currValue) {
        if (index == nums.length) return currValue;

        // Recur by including the current element in the XOR (index+1, currValue^nums[index])
        // and by excluding the current element (index+1, currValue)
        
        
        return helper(nums, index + 1, currValue ^ nums[index]) + helper(nums, index + 1, currValue);
    }
}