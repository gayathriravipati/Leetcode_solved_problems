class Solution {
    //Learnt from techdose and editorial
    public boolean increasingTriplet(int[] nums) {
        int firstVariable = Integer.MAX_VALUE;
        int secondVariable = Integer.MAX_VALUE;
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i] <= firstVariable){
                firstVariable = nums[i];
            }
            else if(nums[i] <= secondVariable){
                secondVariable = nums[i];
            }
            else{
                return true;
            }
        }
        return false;
    }
}