class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        backTrack(0, 0, new ArrayList<>());
        return res;
    }

    private void backTrack(int start, int sum, List<Integer> temp){
        if(sum > target){
            return;
        }

        if(sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);                      
            backTrack(i, sum + candidates[i], temp);      
            temp.remove(temp.size() - 1);                
        }
    }
}