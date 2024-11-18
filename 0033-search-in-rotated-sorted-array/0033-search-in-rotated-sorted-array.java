class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[mid] >= nums[left]){  //condition to find out the sorted array
                if(nums[left] <= target && target < nums[mid]){
                    right = mid;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
        }
        return -1;
    }
}