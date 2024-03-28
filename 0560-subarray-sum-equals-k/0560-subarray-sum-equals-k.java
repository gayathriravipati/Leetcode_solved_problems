class Solution {
    public int subarraySum(int[] nums, int k) {
        int l = nums.length;
        Map<Integer, Integer>mp = new HashMap<>();
        int ps = 0;
        int count = 0;
        mp.put(0, 1);
        for(int i = 0;i<l;i++){
            ps = ps + nums[i];
            
            if(mp.containsKey(ps - k)){
                count += mp.get(ps - k);
            }
            mp.put(ps, mp.getOrDefault(ps, 0) + 1);
        }
        return count;
    }
}
