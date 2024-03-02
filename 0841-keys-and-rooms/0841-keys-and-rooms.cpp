class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int l = rooms.size();
        set<int>visited;
        queue<int>q;
        visited.insert(0); // 0 is unlocked
        //push all the 0th room available keys
        
        for(int i=0;i<rooms[0].size();i++){
            q.push(rooms[0][i]);
            visited.insert(rooms[0][i]);
        }
        
        while(!q.empty()){
            int qs = q.size();
            int te = q.front();
            q.pop();
            for(int i=0;i<rooms[te].size();i++){
                if(visited.find(rooms[te][i])==visited.end()){
                    visited.insert(rooms[te][i]);
                    q.push(rooms[te][i]);
                }
            }
        }
        int ss = visited.size();
        return ss==l;
    }
};