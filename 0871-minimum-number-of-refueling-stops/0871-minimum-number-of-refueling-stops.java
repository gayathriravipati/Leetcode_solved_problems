class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        if(stations.length == 0 && (startFuel < target)){
            return -1;
        }
        
        if(stations.length !=0  && (startFuel < stations[0][0])){
            return -1;
        }
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int prevLocation = 0;
        int fueled = 0;
        
        for(int[] station : stations){
            int location = station[0];
            int fuel = station[1];
            startFuel  = startFuel - (location - prevLocation);
            
            while(!pq.isEmpty() && startFuel < 0){
                startFuel += pq.poll();
                fueled++;
            }
            
            if(startFuel < 0){
                return -1;
            }
            
            pq.offer(fuel);
            prevLocation = location;
            
        }
        
        startFuel  = startFuel - (target - prevLocation);
        while(!pq.isEmpty() && startFuel < 0){
                startFuel += pq.poll();
                fueled++;
        }
        
        if(startFuel < 0){
                return -1;
            }
        return fueled;
    }
}