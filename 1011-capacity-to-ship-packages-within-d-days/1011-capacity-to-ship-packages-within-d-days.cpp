class Solution {
public:
    bool check(vector<int>& weights,int max, int days){
        int md= 1,cl=0;
        int l = weights.size();
        for(int i=0;i<l;i++){
            cl = cl + weights[i];
            if(cl > max){
                cl = weights[i];
                md++;
            }
        }
        return md <= days;
    }
    int shipWithinDays(vector<int>& weights, int days) {
        int len = weights.size();
        int tw = 0,mw=0;
        for(int i=0;i<len;i++){
            if(weights[i] > mw){
                mw = weights[i];
            }
            tw = tw + weights[i];
        }
        int l = mw;
        int r = tw;
    
        while(l < r){
            int m = (l+r) / 2;
            if(check(weights,m,days)){
                r = m;
            }
            else{
                l = m+1;
            }
        }
        return l;
    }
};