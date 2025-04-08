class Solution {
    //Learnt from techdose and editorial
    //5 7 3 9 -- technically, the code is not guaranteeing strict i < j < k if you're being ultra-picky about positions when variables are updated out of order. This results true for the subsequence - 7 3 9 => 3 7 9


    public boolean increasingTriplet(int[] nums) {
        int firstVariable = Integer.MAX_VALUE;
        int secondVariable = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= firstVariable) {
                firstVariable = nums[i];
            } else if (nums[i] <= secondVariable) {
                secondVariable = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}