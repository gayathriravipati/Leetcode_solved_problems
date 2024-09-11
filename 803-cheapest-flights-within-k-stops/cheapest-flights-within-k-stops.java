class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        
        for(int i=0; i<flights.length; i++){
            adjList.computeIfAbsent(flights[i][0], (value -> new ArrayList<>())).add(new int[]{flights[i][1], flights[i][2]});
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<int[]> q = new LinkedList<>();
        int stops = 0;
        q.add(new int[]{src, 0});
        
        while(!q.isEmpty() && stops < k +1){
            int qsize = q.size();
            stops++;
            
            while(qsize-- > 0){
                int[] current = q.poll();
                int node = current[0];
                int node_val = current[1];
            
                if(!adjList.containsKey(node)){
                    continue;
                }
            
                for(int[] neighbors : adjList.get(node)){
                    int new_neighbor = neighbors[0];
                    int new_cost = neighbors[1];
                    if(node_val + new_cost < dist[new_neighbor]){
                        dist[new_neighbor] = node_val + new_cost;
                        q.add(new int[]{new_neighbor, node_val + new_cost});
                    }
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}