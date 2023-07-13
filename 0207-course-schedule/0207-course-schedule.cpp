class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        int nv = 0;
        vector<int> id(numCourses);
        vector<vector<int>> adj(numCourses);
        for(int i=0;i<prerequisites.size();i++){
            id[prerequisites[i][0]]++;
            adj[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        queue<int>q;
        for(int i=0;i<numCourses;i++){
            if(id[i]==0){
                q.push(i);
            }
        }
        while(!q.empty()){
            int n = q.front();
            q.pop();
            nv++;
            for (auto& neighbor : adj[n]) {
                id[neighbor]--;
                if (id[neighbor] == 0) {
                    q.push(neighbor);
                }
            }
        }
         return nv == numCourses;
    }
};