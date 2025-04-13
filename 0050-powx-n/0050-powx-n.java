class Solution {
    public double myPow(double x, int n) {
        if(x==0){
            return 0.0;
        }

        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        return computePower(x, n);
    }

    public double computePower(double x, int n){
        if(n==0){
            return 1.0;
        }

        double half = computePower(x, n/2);

        if(n % 2 == 0){
            return half * half;
        }
        else{
            return half * half * x;
        }
    }
}