class Solution {
public:
    int diagonalSum(vector<vector<int>>& mat) {
        int n = mat.size();
        int s = 0;
        int j = n-1;
        for(int i = 0;i < n;i++){
            //cout << i << " " <<  j << " " << mat[i][i] << " " << mat[i][j] << endl;
            if(i!=j){
                s = s + mat[i][i] + mat[i][j];
            }
            else{
                 s = s + mat[i][i];
            }
            j--;
        }
        
        return s;
    }
};