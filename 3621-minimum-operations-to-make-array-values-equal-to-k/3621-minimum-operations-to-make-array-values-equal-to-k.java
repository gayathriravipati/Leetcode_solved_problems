class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();

        for(int n : nums){
            if(n < k){
                return -1;
            }
            else if(n > k){
                seen.add(n);    
            }   
        }
        return seen.size();
    }
}