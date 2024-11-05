class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //sliding window
        //i,j => 0
        //j < len => we will keeping right => we find a subsum => taregt
//             while(sum > target && i <= j){
//                 //Once t is found, we will move i;
//             }
//             len again
                
         int minLen = Integer.MAX_VALUE;
         int i = 0, j = 0;
         int len = nums.length;
         int sum = 0;
        
        while(j < len){
            System.out.println("ci" + " " + j);
            sum += nums[j];
            System.out.println("sum" + " " + sum);
            if(sum >= target){
                minLen = Math.min(minLen, j-i+1);
                System.out.println("minLen" + " " + minLen);
                while(i <= j){
                    sum -= nums[i];
                    i++;
                    System.out.println("i nd sum" + " "+ i + " " + sum);
                    if(sum >= target){
                        minLen = Math.min(minLen, j-i+1);
                        System.out.println("minLen1" + " " + minLen);
                    }
                    else{
                        break;
                    }
                }
            }
            j++;
        }
        
        if(minLen == Integer.MAX_VALUE){
            return 0;
        }
        
        return minLen;       
    }
}