class Solution {
     List<List<Integer>> possiblePaths = new ArrayList<>();
     int[] candidates;
     int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        backTrack(0, 0, new ArrayList<>());
        return possiblePaths;
    }

    public void backTrack(int idx, int sum, List<Integer> current){
        if(sum > target){
            return;
        }

        if(sum == target){
            // System.out.println(sum);
            // System.out.println(current);
            possiblePaths.add(new ArrayList<>(current));
            return;
        }

        for(int i = idx; i< candidates.length; i++){

            if (i > idx && candidates[i] == candidates[i-1]) {
                continue; 
            }

            if (sum + candidates[i] > target) {
                break; 
            }

            

            current.add(candidates[i]);
            // System.out.println(current + "list");
            backTrack(i+1, sum + candidates[i], current);
            current.remove(current.size() - 1);
            // System.out.println(current + "last elem removal");
        }
    }
}