class Solution {
public:
    bool checkspeed(vector<int>& piles, int h,int m){
        int th = 0;
        //int m =  (l+r) / 2;
        for(int i=0;i<piles.size();i++){
            if(piles[i] % m == 0){
                th = th + (piles[i] / m);
            }
            else{
                th = th + (piles[i] / m) + 1;
            }
        }
        if(th <=h){
            return true;
        }
        else{
            return false;
        }
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int l = 1;
        int r = *max_element(piles.begin(), piles.end());
        
        while(l < r){
            int m = (l+r) / 2;
            if(checkspeed(piles,h,m)){
                r = m;
            }
            else{
                l = m+1;
            }
        }
        return l;
    }
};