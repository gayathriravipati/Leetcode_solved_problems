class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        int itr1 = findmax(nums, 0, nums.length-2);
        int itr2 = findmax(nums, 1, nums.length-1);
        
        return Math.max(itr1, itr2);
    }
    
    private int findmax(int[] nums, int start, int end){
        int t1 = 0;
        int t2 = 0;
        
        for(int i=start; i<=end; i++){
            int val = Math.max(t1 + nums[i], t2);
            t1 = t2;
            t2 = val;
        }
        return t2;
    }
}