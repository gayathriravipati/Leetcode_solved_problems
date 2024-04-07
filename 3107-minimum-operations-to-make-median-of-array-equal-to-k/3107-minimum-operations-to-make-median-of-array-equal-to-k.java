class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int l = nums.length;
        int mid = l / 2;
        long cost = 0;
        
        Arrays.sort(nums);

        if(nums[mid]==k){
            return cost;
        }
        
        if(nums[mid] > k){
            for(int i=0;i<=mid;i++){
                if(nums[i] > k){
                    cost+= nums[i] - k;
                }
            }
        }
        
        if(nums[mid] < k){
            for(int i=mid;i<l;i++){
                if(nums[i] < k){
                    cost+= k - nums[i];
                }
            }
        }
        
        return cost;
    }
}