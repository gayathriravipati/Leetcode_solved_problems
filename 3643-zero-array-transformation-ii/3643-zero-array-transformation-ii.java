class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int right = queries.length;
        int left = 0;
        int res = -1;

        //1. Find the mid element to search for those many queries
        while(left <= right){
            int mid = (left + right) / 2;
            if(processMidQueries(mid,nums,queries)){
                right = mid - 1;
                res = mid;
            }
            else{
                left = mid+1;
            }
        }
        return res;
    }

    public boolean processMidQueries(int k, int[] nums, int[][] queries){
        // 1.Build the difference Array
        int[] diffArray = new int[nums.length + 1];

        for(int start = 0; start < k; start++){
            int left = queries[start][0];
            int right = queries[start][1];
            int value = queries[start][2];
            diffArray[left] = diffArray[left] + value;
            diffArray[right+1] = diffArray[right+1] - value;
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