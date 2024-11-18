class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            // System.out.println(left + " " + right + " " + mid);
            // System.out.println("values");
            // System.out.println(nums[left] + " " + nums[right] + " " + nums[mid]);
            //because the array is rotated we are comparing the mid with the right most element
            if(nums[mid] > nums[right]){
                left = mid + 1;    // sorted is towards right
            }
            else{
                right = mid;
            }
        }
        
        return nums[left];
    }
}