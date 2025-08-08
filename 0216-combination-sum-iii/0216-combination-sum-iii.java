public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int target;

    public List<List<Integer>> combinationSum3(int k, int target) {
        this.target = target;
        backTrack(1, 0, new ArrayList<>(), k);
        return res;
    }

    public void backTrack(int start, int sum, List<Integer> temp, int k){
        if (sum > target || temp.size() > k) {
            return;
        }

        if (sum == target && temp.size() == k) {
            res.add(new ArrayList<>(temp)); 
            return;
        }

        for (int j = start; j <= 9; j++) {
            temp.add(j);
            backTrack(j + 1, sum + j, temp, k);
            temp.remove(temp.size() - 1); 
        }
    }
}
