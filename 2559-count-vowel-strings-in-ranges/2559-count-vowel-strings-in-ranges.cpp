class Solution {
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        int w = words.size();
        int q = queries.size();
        vector<int>m(w,0);
         vector<int>res(q,0);
        
        for(int i=0;i<w;i++){
            int l = words[i].size();
             bool first = words[i][0]=='a'||words[i][0]=='e'||words[i][0]=='i'||words[i][0]=='o'||words[i][0]=='u';
               
             bool last = words[i][l-1]=='a'||words[i][l-1]=='e'||words[i][l-1]=='i'||words[i][l-1]=='o'||words[i][l-1]=='u';
                 
             if(first&&last){
                 if(i>0){
                     m[i] = m[i-1]+1;
                 }
                 else{
                     m[i] = 1;
                 }
             }
            
            else{
                if(i>0){
                    m[i] = m[i-1];
                }
                
            }
        }
        
        
        for(int j=0;j<q;j++){
            
            if(queries[j][0] > 0){
                int a = m[queries[j][1]] - m[queries[j][0]-1];
                res[j]=a;
            }
            else{
                int a = m[queries[j][1]];
                res[j]=a;
            }
        }
          return res;
    }
};