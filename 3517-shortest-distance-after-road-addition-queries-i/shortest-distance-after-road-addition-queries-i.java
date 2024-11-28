class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            adjList.get(i).add(i+1);
        }
        
        for(int[] query : queries){
            adjList.get(query[0]).add(query[1]);
            int val = minSteps(adjList);
            answer.add(val);
        }
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;

    }
    
    public int minSteps(List<List<Integer>> adjList){
        int n = adjList.size();
        
        int[] dp = new int[n];
        dp[n-1] = 0;
        
        for(int i = n-2; i>=0; i--){
            int minVal = n;
            for(int neighbor : adjList.get(i)){
                int val = dp[neighbor] + 1;
                minVal = Math.min(minVal, val);
            }
            dp[i] = minVal;
        }
        return dp[0];
    }
    
}