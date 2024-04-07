class Solution {
    
    public int findincreasing(int[] nums, int l) {
        int i=0, j=i+1;
        int c = 1;
        int ml = 1;
        while(j<l){
            if(nums[j] > nums[j-1]){
                c++;
            }
            else{
                if(c>ml){
                    ml = c;
                }
                c = 1;
            }
            j++;
        }
        if(c > ml){
            ml = c;
        }
        return ml;
    }
    
    public int finddecreasing(int[] nums, int l) {
        int i=0,j=i+1;
        int c = 1;
        int ml = 1;
        while(j<l){
            if(nums[j] < nums[j-1]){
                c++;
            }
            else{
                if(c>ml){
                    ml = c;
                }
                c = 1;
            }
            j++;
        }
        if(c > ml){
            ml = c;
        }
        return ml;
    }
    
    public int longestMonotonicSubarray(int[] nums) {
        int len = nums.length;
        if(len==1){
            return len;
        }
        int in = findincreasing(nums,len);
        int de = finddecreasing(nums,len);
        if(in>de){
            return in;
        }
        
        return de;
    }
}