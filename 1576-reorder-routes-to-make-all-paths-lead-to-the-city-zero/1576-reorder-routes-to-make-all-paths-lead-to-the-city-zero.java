class Solution {
    public int minReorder(int n, int[][] connections) {
        //Let's build adjacency list
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            al.add(new ArrayList<>());
        }

        //Bottomline of adding -1 to the src is to have a link from child to parent also, for us to traverse and count the number of edges to be flipped
        for(int[] conn : connections){
            int from = conn[0];
            int to = conn[1];
            al.get(from).add(to);
            al.get(to).add(-1 * from);
        }
        boolean[] visited = new boolean[n];
        return dfs(0, al, visited);
    }

    public int dfs(int src, List<List<Integer>> al, boolean[] visited){
        visited[src] = true;
        int change = 0;

        for(int city : al.get(src)){
            if(!visited[Math.abs(city)]){
                change = change + (city > 0 ? 1 : 0);
     //because it is away from source so we need to flip it. As we want the neighbor to be pointed towards the source
                change = change + dfs(Math.abs(city), al, visited);
            }
        }

        return change;
    }
}