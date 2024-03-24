class Solution {
    public int findDuplicate(int[] nums) {
        int l = nums.length;
        int ts = (l * (l+1)) / 2;
        Set<Integer> st = new HashSet<>(); 
        for(int i=0;i<l;i++){
            if(st.contains(nums[i])){
                return nums[i];
            }
            else{
                st.add(nums[i]);
            }
        }
        return -1;
    }
}