class Solution {
    public int findChampion(int n, int[][] edges) {
        Set<Integer> teamID = new HashSet<>();
        
        for(int i=0; i<n; i++){
            teamID.add(i);
        }
        
        for(int[] edge : edges){
            if(teamID.contains(edge[1])){
                teamID.remove(edge[1]);
            }
        }
        
        if(teamID.size() >1 || teamID.size() == 0){
            return -1;
        }
        
        int element = teamID.stream().findFirst().orElseThrow();
        return element;
    }
}