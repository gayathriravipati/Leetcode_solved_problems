class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int one = nums1.length;
        int two = nums2.length;
        int i=0,j=0;
        while(i<one && j<two){
            if(nums1[i]==nums2[j]){
                return nums1[i];
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return -1;
    }
}