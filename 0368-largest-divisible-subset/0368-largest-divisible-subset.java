class Solution {
    //Learnt from meetcode and editorial
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;

        if(len == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> divisibleStack = new ArrayList<>();

        for(int i=0; i<len; i++){
            divisibleStack.add(new ArrayList<>());
        }

        Arrays.sort(nums);
        int n = len;

        for(int i = n-1; i>=0; i--){
            List<Integer> tempStack = new ArrayList<>();
            for(int j = i+1; j<n; j++){
                if((nums[j] % nums[i] == 0) && (divisibleStack.get(j).size() > tempStack.size())){
                    tempStack = divisibleStack.get(j);
                }
            }
            divisibleStack.get(i).addAll(tempStack);
            divisibleStack.get(i).add(nums[i]);
        }

        List<Integer> largestSubset = new ArrayList<>();

        for(List<Integer> t : divisibleStack){
            if(t.size() > largestSubset.size()){
                largestSubset = t;
            }
        }

        return largestSubset;
    }
}