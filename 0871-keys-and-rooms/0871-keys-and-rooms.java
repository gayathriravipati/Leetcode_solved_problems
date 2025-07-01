class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] status = new boolean[n];
        status[0] = true;
        int visited = 0;
        Stack<Integer> keys = new Stack<>();
        List<Integer> currentKeys = rooms.get(0);
        for(int i : currentKeys){
            if(!status[i]){
                keys.add(i);
                status[i] = true;
                visited++;
                if(visited == n-1){
                    return true;
                }
            }
        }

        while(!keys.isEmpty()){
            int idx = keys.pop();
            currentKeys = rooms.get(idx);
            for(int i : currentKeys){
                if(!status[i]){
                    keys.add(i);
                    status[i] = true;
                    visited++;
                    if(visited == n-1){
                        return true;
                    }
                }
            }
        }

        // for(int i=0; i<n; i++){
        //     if(!status[i]) return false;
        // }

        return false;
    }
}