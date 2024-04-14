class Solution {
    private boolean isprime(int n){
        for(int i=2; i<=n/2;i++){
            if(n % i == 0){
                return false;
            }
        }
        System.out.println("prime " + " " +  n);
        
        if(n==1){
            return false;
        }
        return true;
    }
    
    public int maximumPrimeDifference(int[] nums) {
        int maxv = Integer.MIN_VALUE;
	    int minv = Integer.MAX_VALUE;
        
        for(int i = 0;i<nums.length;i++){
            
            if(isprime(nums[i])){
                minv = Math.min(minv,i);
                maxv = Math.max(maxv,i);
            }
            
        }
        System.out.println(minv + " " + maxv);
        return maxv - minv;
        
    }
}