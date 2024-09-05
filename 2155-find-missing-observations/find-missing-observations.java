class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for(int num : rolls){
            sum += num;
        }
        
        int remainingSum = ((rolls.length + n) * mean) - sum;
       
        if(n * 6 < remainingSum || remainingSum < n){
            return new int[0];
        }
        
        int distributedCount = remainingSum / n;
        int mod = remainingSum % n;
        
        int[] res = new int[n];
        Arrays.fill(res, distributedCount);
        for(int i=0; i<mod; i++){
            res[i]++;
        }
        
        return res;
        
    }
}