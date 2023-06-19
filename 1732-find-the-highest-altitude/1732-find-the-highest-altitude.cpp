class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        vector<int> result;
        int ans = 0;
        int max = 0;
        
        for(int i=0;i<gain.size();i++){
            ans = gain[i] + ans;
            if(ans>max){
                max = ans;
            }
        }
        return max;
    }
};