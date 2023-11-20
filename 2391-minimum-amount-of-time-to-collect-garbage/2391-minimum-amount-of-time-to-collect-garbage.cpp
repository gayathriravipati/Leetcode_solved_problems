class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        map<char,int>gc;
        map<char,int>glp;
        int l = travel.size();
        int gl = garbage.size();
        vector<int>ps(l+1,0);
        
        //computing the prefix sum
        ps[1] = travel[0];
        for(int i=1;i<l;i++){
            ps[i+1] = travel[i] + ps[i];
        }
        
        //updating both the maps
        for(int i=0;i<gl;i++){
            for(char c: garbage[i]){
                glp[c] = i;
                gc[c]++;
            }
        }
        
        
        
        char garbageTypes[3] = {'M', 'P', 'G'};
        int ans = 0;
        for (char c : garbageTypes) {
            if(gc[c]){
                ans = ans + gc[c] + ps[glp[c]];
            }   
        }
        
        
        
        
        
        return ans;
    }
};