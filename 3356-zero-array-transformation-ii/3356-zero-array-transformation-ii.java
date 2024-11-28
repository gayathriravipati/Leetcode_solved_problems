class Solution {
    public boolean check(int[] nums, int[][] queries, int k) {
        int[] res = new int[nums.length];
        
        for (int i = 0; i < k; i++) { 
            int start = queries[i][0];
            int end = queries[i][1];
            int val = queries[i][2];
            
            res[start] -= val;
            if (end < nums.length - 1) {  
                res[end + 1] += val;
            }
        }
        
        int[] tmp = Arrays.copyOf(nums, nums.length);
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += res[i];
            tmp[i] += curr;
            if (tmp[i] > 0) {
                return false;
            }
        }
        return true;
    }
    
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0;
        int right = queries.length;  
        int ans = -1; 
        
        while (left <= right) {  
            int k = left + (right - left) / 2;
            if (check(nums, queries, k)) {  
                ans = k;  
                right = k - 1;  
            } else {
                left = k + 1; 
            }
        }
        
        return ans;
    }
}
