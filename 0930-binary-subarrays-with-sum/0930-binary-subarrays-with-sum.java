class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int l = nums.length;
        int c = 0;
        for(int i = 0;i<l;i++){
            int ps = nums[i];
            if(ps==goal){
              c++;
            }
            for(int j = i+1; j<l && ps <= goal; j++){
                ps = ps + nums[j];
                if(ps==goal){
                  c++;
                }
            }
        }
        return c;
    }
}