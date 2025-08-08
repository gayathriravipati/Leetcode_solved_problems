class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        backTrack(0, 0, temp);
        return res;
    }

    public void backTrack(int idx, int sum, List<Integer> temp){
        if(sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(sum > target){
            return;
        }

        for(int i = idx; i<candidates.length; i++){
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            int newSum = sum + candidates[i];
            if (newSum > target) break; 
            temp.add(candidates[i]);
            backTrack(i+1, sum + candidates[i], temp);
            temp.remove(temp.size() - 1);
        }
    }
}