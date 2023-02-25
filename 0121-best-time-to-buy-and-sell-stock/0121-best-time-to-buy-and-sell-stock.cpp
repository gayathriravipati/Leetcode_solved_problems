class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int i=0,p=0,sv;
        sv = prices[i];
        for(int j=1;j<prices.size();j++){
            if(prices[j] < sv){
                sv = prices[j];
            }
            
            if(prices[j] - sv > p){
                p = prices[j] - sv;
            }
        }
        return p;
    }
    
};