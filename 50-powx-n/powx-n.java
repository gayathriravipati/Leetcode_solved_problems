class Solution {
    public double myPow(double x, int n1) {
        long n = (long) n1;
        if(n==0){
            return 1.0;
        }
        
        if (n < 0) {
            n = -1 * n;
            x = 1.0 / x;
        }
        
        
        double result = 1.0;
        
        while(n > 0){
            // System.out.println(n + "n");
            if(n % 2 != 0){
                result = result * x;
                n--;
                // System.out.println(result + "res");
            }
            
                x = x * x;
                n = n / 2;
            // System.out.println(x + " " + n + "x,n");
        }
        return result;
    }
}