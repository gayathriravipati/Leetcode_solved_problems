class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int next_num = 1;
        
        for(int i=1; i<n; i++){
            next_num = Math.min(nums[i2] * 2, Math.min(nums[i3] * 3, nums[i5] * 5));
            nums[i] = next_num;
            
            if(nums[i2] * 2 == next_num){
                i2++;
            }
            
            if(nums[i3] * 3 == next_num){
                i3++;
            }
            
            if(nums[i5] * 5 == next_num){
                i5++;
            }
        }
        return next_num;
    }
}