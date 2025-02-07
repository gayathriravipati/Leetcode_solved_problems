class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCnt = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int p = nums[i] * nums[j];
                productCnt.put(p, productCnt.getOrDefault(p,0) + 1);
            }
       }

       int count = 0;
       for(int freq : productCnt.values()){
           count += 8 * (freq * (freq - 1) / 2);
       }
        return count;
    }
}