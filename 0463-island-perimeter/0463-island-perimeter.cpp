class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int r = grid.size();
        int c = grid[0].size();
        int v = 0;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    int up = (i == 0) ? 0 : grid[i-1][j];
                    int down = (i == r-1) ? 0 : grid[i+1][j];
                    int left = (j == 0) ? 0 : grid[i][j-1];
                    int right = (j == c-1) ? 0 : grid[i][j+1];
                    
                    v += 4 - (up + down + left + right);
                }
            }
        }
        
        return v;
    }
};
