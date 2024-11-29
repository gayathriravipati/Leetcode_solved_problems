class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        
        if(nums.length == 1 && nums[0] == val){
            return 0;
        }
        
        while(i <= j){
            while(nums[j] == val && j > i){
                j--;
            }
            if(nums[i] == val){
                nums[i] = nums[j];
                j--;
            }
            i++;
        }
        return j + 1;
    }
}