class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int count = 0;
        int tc = grid[0].size();
        int cni = tc - 1;
        //cout << cni << "cni" << endl;
        for(int i=0;i<grid.size();i++){
            while(cni >=0 && grid[i][cni]<0){
                cni--;
            }
            //cout << cni << endl;
            count = count + (tc - (cni + 1));
        }
        return count;
    }
};