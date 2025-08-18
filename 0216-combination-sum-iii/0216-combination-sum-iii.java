class Solution {
    List<List<Integer>> combinations = new ArrayList<>();
    int k;
    int target;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.target = n;
        backTrack(1, 0, new ArrayList<>());
        return combinations;
    }

    private void backTrack(int idx, int sum, List<Integer> path){
        if(sum == target && path.size() == k){
            combinations.add(new ArrayList<>(path));
            return;
        }

        if(sum > target || path.size() > k){
            return;
        }

        for(int i = idx; i<=9; i++){
            path.add(i);
            backTrack(i+1, sum + i, path);
            path.remove(path.size()-1);
        }
    }
}