class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        
        q.add(0);
        seen.add(0);
        
        while(!q.isEmpty()){
            int currentRoom = q.poll();
            for(int i = 0; i<rooms.get(currentRoom).size(); i++){
                if(!seen.contains(rooms.get(currentRoom).get(i))){
                    seen.add(rooms.get(currentRoom).get(i));
                    q.add(rooms.get(currentRoom).get(i));
                }
            }
        }
        
        if(seen.size() == rooms.size()){
            return true;
        }
        return false;
    }
}