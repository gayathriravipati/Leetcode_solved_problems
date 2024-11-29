class Solution {
    public void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        k = k % nums.length;
        // System.out.println(nums.length + " " + k);
        for(int i = 0; i<nums.length; i++){
            int new_idx = (i + k) % nums.length;
            // System.out.println(i + " " + new_idx);
            res[new_idx] = nums[i];
        }
        
        for(int i = 0; i<nums.length; i++){
            nums[i] = res[i];
        }
    }
}