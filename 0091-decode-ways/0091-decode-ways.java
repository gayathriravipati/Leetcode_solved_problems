class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i=2; i<dp.length; i++){
            dp[i] = s.charAt(i-1) == '0' ? 0 : dp[i-1];
            
            int val = Integer.valueOf(s.substring(i-2,i));
            
            if(val >= 10 && val <= 26){
                dp[i] += dp[i-2];
            }
            
        }
        return dp[s.length()];
    }
}