class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
       cost.push_back(0);
       int l = cost.size();
       for(int i=l-3;i>=0;i--){
           cost[i] = cost[i] + min(cost[i+1],cost[i+2]);
       }
        return min(cost[0],cost[1]);
    }
};