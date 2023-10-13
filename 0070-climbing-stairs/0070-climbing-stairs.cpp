class Solution {
public:
    int climbStairs(int n) {
        long long int one =1, two=1;
        int t;
        for(int i=n;i>0;i--){
            t = one;
            one = one + two;
            two = t;
        }
        return t;
    }
};