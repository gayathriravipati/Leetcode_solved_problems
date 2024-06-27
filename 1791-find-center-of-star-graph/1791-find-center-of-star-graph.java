class Solution {
    public int findCenter(int[][] edges) {
        int c = 0;
        int len = edges.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int val = 0;
        
        for(int i=0; i<len; i++){
            mp.put(edges[i][0], mp.getOrDefault(edges[i][0], 0) + 1);
            mp.put(edges[i][1], mp.getOrDefault(edges[i][1], 0) + 1);
            
            if(mp.get(edges[i][0]) == len){
                val = edges[i][0];
            }
            
            if(mp.get(edges[i][1]) == len){
                val = edges[i][1];
            }
            
        }
        return val;
    }
}