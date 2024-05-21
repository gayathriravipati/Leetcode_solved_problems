class Solution {
    List<List<Integer>> listOfLists = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        listOfLists.add(new ArrayList<>());
        return findsubsets(nums, 0);
    }
    
    private List<List<Integer>> findsubsets(int[] nums, int index) {
        if (index == nums.length) {
            return listOfLists;
        }
        
        int l = listOfLists.size();
        for (int i = 0; i < l; i++) {
            List<Integer> innerList = listOfLists.get(i); 
            List<Integer> modifiedList = new ArrayList<>(innerList);
            modifiedList.add(nums[index]); 
            listOfLists.add(modifiedList);
        }
        return findsubsets(nums, index + 1);
    }
}