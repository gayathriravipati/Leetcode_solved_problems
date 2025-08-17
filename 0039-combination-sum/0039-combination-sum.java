class Solution {
    List<List<Integer>> possiblePaths = new ArrayList<>();
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // sort
        // idx - tracking => if idx beyond or sum beyond return;
        // remove last elemet and keep trying combinations with other elements.
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        backTrack(0, 0, new ArrayList<>());
        return possiblePaths;
    }

    public void backTrack(int idx, int sum, List<Integer> current){
        if(idx > candidates.length - 1 || sum > target){
            return;
        }

        if(sum == target){
            // System.out.println(sum);
            // System.out.println(current);
            possiblePaths.add(new ArrayList<>(current));
            return;
        }

        for(int i = idx; i<candidates.length; i++){
            if (sum + candidates[i] > target) {
                break; 
            }
            current.add(candidates[i]);
            // System.out.println(current + "list");
            backTrack(i, sum + candidates[i], current);
            current.remove(current.size() - 1);
            // System.out.println(current + "last elem removal");
        }
    }
}