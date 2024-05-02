class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> positive = new HashSet<>();
        Set<Integer> negative = new HashSet<>();
        for(int num:nums){
            if(num > 0){
                positive.add(num);
            }
            else{
                negative.add(num);
            }
        }
        int res = -1;
        
        for (int element : positive) {
            if (negative.contains(-1 * element)){
                res = Math.max(res,element);
            }
        }
        return res;
    }
}