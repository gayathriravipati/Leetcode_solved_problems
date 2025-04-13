class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] res = new int[2];

        for(int i = 0; i<nums.length; i++){
            int n = target - nums[i];
            if(indexMap.containsKey(n)){
                res[0] = indexMap.get(n);
                res[1] = i;
                break;
            }
            indexMap.put(nums[i], i);
        }
        return res;
    }
}