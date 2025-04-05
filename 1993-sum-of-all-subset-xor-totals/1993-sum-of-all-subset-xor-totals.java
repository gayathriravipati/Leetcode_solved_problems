class Solution {
    public int subsetXORSum(int[] nums) {
        return findXOR(nums, 0, 0);
        //(array, index, currValue);
    }

    private int findXOR(int[] nums, int index, int currValue){
        if(index == nums.length){
            return currValue;
        }

        return findXOR(nums, index+1, currValue ^ nums[index]) + findXOR(nums, index+1, currValue);
    }
}