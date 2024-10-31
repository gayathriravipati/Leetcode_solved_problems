class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minDistance = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for(int i = 0; i < points.length; i++){
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            // dist = (int) Math.sqrt(dist);
            minDistance.add(new int[]{dist, i});
            
            if(minDistance.size() > k){
                minDistance.poll();
            }
        }
        
        int[][] result = new int[k][2];
        int i=0;
        while(!minDistance.isEmpty()){
            var top = minDistance.poll();
            int idx = top[1];
            result[i][0] = points[idx][0];
            result[i][1] = points[idx][1];
            i++;
        }
        
        return result;
    }
}