class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
    
        int i = 0, j = 0;
        int len = nums.length;
        
        //base case
        if(len < k){
            return 0;
        }
        
        long maxSum = Integer.MIN_VALUE;
        Set<Integer> st = new HashSet<>();
        long currSum = 0;
        
        while(j < len){
            
            if(!st.contains(nums[j])){
                
                currSum += nums[j];
                st.add(nums[j]);
                
                if(st.size() == k){
                    maxSum = Math.max(currSum, maxSum);
                    currSum -= nums[i];
                    st.remove(nums[i]);
                    i++;
                }
                
            }
            
            else{
                
                while(st.contains(nums[j]) && i < j){
                    st.remove(nums[i]);
                    currSum -= nums[i];
                    i++;
                }
                
                st.add(nums[j]);
                currSum += nums[j];
            }
            j++;
        }
        
        if(st.size() == k){
            maxSum = Math.max(currSum, maxSum);
        }
        
        if(maxSum != Integer.MIN_VALUE){
            return maxSum;
        }
        
        return 0;
    }
}