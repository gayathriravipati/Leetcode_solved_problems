class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        vector<int> result;
        //int t=gain[0];
        int ans = 0;
        int max = 0;
        //result.push_back(0);
        
        for(int i=0;i<gain.size();i++){
            ans = gain[i] + ans;
            cout << ans << endl;
            if(ans>max){
                max = ans;
            }
        }
        return max;
    }
};