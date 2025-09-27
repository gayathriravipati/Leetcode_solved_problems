class Solution {
    public int climbStairs(int n) {
        //This is a pattern to find the fibonacci number 1- 1 , 2 - 2, 3 => 3, 
        // 4 - 1,1,1,1.  2,2   1,1,2   2,1,1
        // 1 2 3 
        if(n==1){
            return 1;
        }

        if(n==2){
            return 2;
        }

        int oneStepBack = 2;
        int twoStepBack = 1;
        int res = 0;

        for(int i = 3; i <= n; i++){
            res = twoStepBack + oneStepBack;
            twoStepBack = oneStepBack;
            oneStepBack = res;
        }
        return res;
    }
}