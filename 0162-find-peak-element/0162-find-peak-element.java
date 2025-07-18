//Learnt from neetcode
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 0;
        }

        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(mid > 0 && nums[mid-1] > nums[mid]){
                high = mid - 1;
            }

            else if(mid < n-1 && nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }

            else{
                return mid;
            }
        }
        return 0;
    }
}