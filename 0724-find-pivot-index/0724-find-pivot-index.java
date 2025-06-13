class Solution {
    public int pivotIndex(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int len = nums.length;

        leftSum[0] = 0;
        rightSum[len-1] = 0;

        for(int i=1; i<len; i++){
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }

        for(int j=len-2; j>=0; j--){
            rightSum[j] = rightSum[j+1] + nums[j+1];
        }

        for(int i=0; i<len; i++){
            if(leftSum[i] == rightSum[i]){
                return i;
            }
        }
        return -1;
    }
}