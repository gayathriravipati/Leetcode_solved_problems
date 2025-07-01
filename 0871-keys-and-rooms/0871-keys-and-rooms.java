class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] status = new boolean[n];
        status[0] = true;
        int visited = 1;
        Stack<Integer> keys = new Stack<>();
        keys.push(0);  


        while(!keys.isEmpty()){
            int idx = keys.pop();
            List<Integer> currentKeys = rooms.get(idx);
            for(int i : currentKeys){
                if(!status[i]){
                    keys.add(i);
                    status[i] = true;
                    visited++;
                    if(visited == n){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}