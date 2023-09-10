class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
       map<vector<int>,int >m;
       int n = grid.size();
       for(int i =0;i<n;i++){
           vector<int>temp;
           for(int j =0;j<n; j++){
            temp.push_back(grid[i][j]);
           }
           m[temp]++;
       }
      
       int cnt = 0;
        for(int j=0;j<n;j++){
          vector<int>temp;
           for(int i =0;i<n; i++){
               temp.push_back(grid[i][j]);
           }
           if(m.find(temp) != m.end()){
               cnt += m[temp];
           }
           }
           return cnt; 
    }
};