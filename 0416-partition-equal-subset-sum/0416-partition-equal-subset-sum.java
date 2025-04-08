class Solution {
    //Solution learnt from Neetcode
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        if(totalSum % 2 != 0){
            return false;
        }

        int target = totalSum / 2;

        HashSet<Integer> firstSet = new HashSet();
        firstSet.add(0);

        for(int i = len-1; i>=0; i--){
            HashSet<Integer> secondSet = new HashSet();
            for(int n : firstSet){
                secondSet.add(n);
                secondSet.add(n + nums[i]);
                if(n + nums[i] == target){
                    return true;
                }
            }
            firstSet = secondSet;
        }
        return false;
    }
}