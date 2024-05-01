class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int val;
        return -1 *(nums1[0]-nums2[0]);
    }
}