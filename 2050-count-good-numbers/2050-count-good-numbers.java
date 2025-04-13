class Solution {
    long mod = 1000000007;
    public int countGoodNumbers(long n) {
        long evenPositions = quickmul(5, (n + 1) / 2);
        long oddPositions = quickmul(4, n / 2);
        long result = (evenPositions * oddPositions) % mod;
        return (int) result;
    }

    private long quickmul(long x, long n){
         if(n == 0){
            return 1;
         }

         long half = quickmul(x, n/2);
         if(n % 2 == 0){
            return (half * half) % mod;
         }
         else{
            return (half * half * x) % mod;
         }
    }
}