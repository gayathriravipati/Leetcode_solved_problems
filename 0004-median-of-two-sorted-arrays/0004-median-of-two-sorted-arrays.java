class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int left = 0;
        int right = m;
        
        while(left <= right){
            int pA = (left + right) / 2;
            int pB = (len + 1) / 2 - pA;
            
            int maxA = (pA == 0) ? Integer.MIN_VALUE : nums1[pA-1];
            int maxB = (pB == 0) ? Integer.MIN_VALUE : nums2[pB-1];
            
            int minA = (pA == m) ? Integer.MAX_VALUE : nums1[pA];
            int minB = (pB == n) ? Integer.MAX_VALUE : nums2[pB];
            
            if(maxA <= minB && maxB <= minA){
                if(len % 2 == 0){
                    int val = Math.max(maxA, maxB) + Math.min(minA, minB);
                    return val / 2.0;
                }
                else{
                    return (double) Math.max(maxA, maxB);
                }
                
            }
            else if(maxA > minB){
                right = pA -1;
            }
            else{
                left = pA + 1;
            }
        }
        return 0.0;
    }
}