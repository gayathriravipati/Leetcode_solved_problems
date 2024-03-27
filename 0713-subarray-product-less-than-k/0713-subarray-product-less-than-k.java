// class Solution {
//     public int numSubarrayProductLessThanK(int[] nums, int k) {
//         int l = nums.length;
//         int c = 0;
//         int tp = 1;
        
//         for(int i=0;i<l;i++){
            
//             if(nums[i] < k){
//                 c++;
//                 System.out.println(i + " " +  "1");
//                 tp = nums[i];
                
//                 for(int j = i+1; j<l; j++){
//                     if(tp * nums[j] > k){
//                         break;
//                     }
//                     else if(tp * nums[j] < k){
//                         System.out.println(i + " " + j + " " + "2");
//                         c++;
//                         tp = tp * nums[j];
//                     }
//                 }
//             }
            
//         }
//         return c;
//     }
// }


class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; 
        int count = 0;
        int product = 1;
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            
            while (product >= k) {
                product /= nums[left++];
            }
            
            count += right - left + 1;
        }
        
        return count;
    }
}
