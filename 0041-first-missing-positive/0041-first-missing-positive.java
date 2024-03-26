class Solution {
    public int firstMissingPositive(int[] nums) {
        int l = nums.length;
        Set<Integer> st = new HashSet<>(); 
        int maxv = 0;
	    int minv = Integer.MAX_VALUE;

        
        for(int i=0;i<l;i++){
            st.add(nums[i]);
            minv = Math.min(minv, nums[i]);
            maxv = Math.max(maxv, nums[i]);
        }
        
        for (Integer element : st) {
            System.out.println(element);
        }

        
        
        for(int i=1;i< maxv;i++){
            if(!st.contains(i)){
                return i;
            }
        }
        
        return maxv+1;
    }
}