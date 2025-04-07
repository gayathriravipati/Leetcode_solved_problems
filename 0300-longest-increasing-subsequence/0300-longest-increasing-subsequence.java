class Solution {
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n];

    //     dp[n-1] = 1;
    //     int prev = 1;

    //     for(int i=n-2; i>=0; i--){
    //         int maxV = 0;
    //         for(int j = i+1; j<n; j++){
    //             if(nums[i] < nums[j]){
    //                 maxV = Math.max(maxV, dp[j]);
    //             }
    //         }
    //         dp[i] = 1 + maxV;
    //         prev = Math.max(prev, dp[i]);
    //      }
    //      return prev;
    // }

    //consider checking the O(n log n) solution as well from the editorial.

    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);

        for(int i=1; i<nums.length; i++){
            if(nums[i] > lis.get(lis.size() -1)){
                lis.add(nums[i]);
            }
            else{
                int idx = binarySearch(lis, nums[i]);
                lis.set(idx, nums[i]);
            }
        }
        return lis.size();
    }

    private int binarySearch(List<Integer> lis, int target){
        int left = 0;
        int right = lis.size()-1;

        while(left < right){
            int mid = (left + right) / 2;
            if(lis.get(mid) == target){
                return mid;
            }
            else if(lis.get(mid) < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}