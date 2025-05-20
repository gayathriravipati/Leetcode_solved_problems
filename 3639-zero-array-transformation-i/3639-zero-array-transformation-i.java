class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        // 1.Build the difference Array
        int[] diffArray = new int[nums.length + 1];

        for(int[] query : queries){
            int left = query[0];
            int right = query[1];
            diffArray[left] = diffArray[left] + 1;
            diffArray[right+1] = diffArray[right+1] - 1;
        }
        //Build the prefixSum Array
        int total = 0;
        for(int i = 1; i<diffArray.length; i++){
            diffArray[i] = diffArray[i] + diffArray[i-1];
        }

        // for(int i = 0; i<nums.length; i++){
        //     System.out.println(diffArray[i]  + " " + nums[i]);
        // }

        //Verify if every element is higher when compared to original array
        for(int i = 0; i<nums.length; i++){
            if(diffArray[i] < nums[i]){
                // System.out.println(i);
                return false;
            }
        }
        return true;
    }
}