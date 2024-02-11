class Solution {
public:
    vector<vector<int>> modifiedMatrix(vector<vector<int>>& matrix) {
        int i,j;
        int l = matrix.size();
        //cout << l << "len" << endl;
            
        for(i=0;i<matrix[0].size();i++){
            vector<int>idx;
            int me = INT_MIN;
            //cout << i << "column" << endl;
            for(j=0;j<l;j++){
                //cout << j << "row" << endl;
                if(matrix[j][i]== -1){
                    idx.push_back(j);
                }
                if(matrix[j][i] > me){
                    me = matrix[j][i];
                }
            }
            
            // cout << i << "column" <<endl;
            // cout << me << "maax" << endl;
            // cout << "indexes" << endl;
            
//             for(int k=0; k<idx.size(); k++){
//                 cout << idx[k] << endl;
//             }
                
            for(int k=0; k<idx.size(); k++){
                matrix[idx[k]][i] = me;
            }
            
        }
        
        return matrix;
        
    }
};
