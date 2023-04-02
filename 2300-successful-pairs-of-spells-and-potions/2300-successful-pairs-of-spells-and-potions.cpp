class Solution {
public:
    int findelement(vector<int>& potions, long long a){
        int lp = potions.size()-1;
        int ans=lp+1;
        int k=0;
        while(k<=lp){
            int m = k+(lp-k) / 2;
            if(potions[m] < a){
                k = m+1;
            }
            else{
                if(m<ans){
                    ans=m;
                }
                lp = m-1;
            }
        }
        if(ans==potions.size()){
            return 0;
        }
        if(ans<=0){
            return potions.size();
        }
        return potions.size()-ans;
    }
    
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        sort(potions.begin(),potions.end());
        vector<int>res;
        int lp = potions.size();
        for(int i=0;i<spells.size();i++){
            long long a = ceil((1.0*success) / spells[i]);
            int ei = findelement(potions,a);
            // int te = lp - ei;
            res.push_back(ei);
        }
        return res;
    }
};