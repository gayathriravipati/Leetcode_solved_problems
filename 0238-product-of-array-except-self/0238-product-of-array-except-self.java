class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftProduct = new int[len];
        int[] rightProduct = new int[len];

        leftProduct[0] = nums[0];
        rightProduct[len-1] = nums[len - 1];

        for(int i=1; i<len; i++){
            leftProduct[i] = leftProduct[i-1] * nums[i];
        }

        for(int j=len-2; j>=0; j--){
            rightProduct[j] = rightProduct[j+1] * nums[j];
        }

        int[] res = new int[len];

        res[0] =  rightProduct[1];
        res[len-1] =  leftProduct[len-2];

        for(int i=1; i<len-1; i++){
            res[i] = leftProduct[i-1] * rightProduct[i+1];
        }
        return res;
    }
}