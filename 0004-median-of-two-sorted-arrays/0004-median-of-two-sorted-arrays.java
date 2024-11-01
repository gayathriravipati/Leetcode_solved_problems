class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        
        int[] sortedArray = new int[len];
        int i = 0, j = 0;
        int idx = 0;
        
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                sortedArray[idx++] = nums1[i++];
            } else {
                sortedArray[idx++] = nums2[j++];
            }
        }
        
        while (i < len1) {
            sortedArray[idx++] = nums1[i++];
        }
        
        while (j < len2) {
            sortedArray[idx++] = nums2[j++];
        }
        
        int mid = len / 2;
        if (len % 2 == 0) {
            return (sortedArray[mid - 1] + sortedArray[mid]) / 2.0;  
        } else {
            return (double) sortedArray[mid];  
        }
    }
}
