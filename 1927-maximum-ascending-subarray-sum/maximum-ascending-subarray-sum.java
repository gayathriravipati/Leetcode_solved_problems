class Solution {
    
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        int currentElement = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i] > currentElement){
                sum += nums[i];
                // System.out.println(nums[i]);
            }
            else{
                // System.out.println("broke");
                if(sum > maxSum){
                    maxSum = sum;
                }
                sum = nums[i];
            }
            currentElement = nums[i];
        }

        if(sum > maxSum){
            maxSum = sum;
        }

        return maxSum;
    }
}