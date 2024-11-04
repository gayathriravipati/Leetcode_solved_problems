class Solution {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        
        if(n==2){
            return 2;
        }
        
        int oneBack = 2;
        int twoBack = 1;
        int res = 0;
        
        for(int i=3; i<=n; i++){
            res = oneBack + twoBack;
            twoBack = oneBack;
            oneBack = res;
        }
        return res;
    }
}