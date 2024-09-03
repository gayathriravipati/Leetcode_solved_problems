class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        Set<Integer> visitedRooms = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visitedRooms.add(0);
        
        while(!q.isEmpty()){
            int idx = q.poll();
            List<Integer> possibleRooms = rooms.get(idx);
            for(int j=0; j<possibleRooms.size(); j++){
                if(!visitedRooms.contains(possibleRooms.get(j))){
                    q.add(possibleRooms.get(j));
                    visitedRooms.add(possibleRooms.get(j));
                }
            }
        }
        
        int len = visitedRooms.size();
        
        if(len==n){
            return true;
        }
        
        return false;
    }
}