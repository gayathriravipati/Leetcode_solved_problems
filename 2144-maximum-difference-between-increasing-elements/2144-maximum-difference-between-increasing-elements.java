// class Solution {
//     //O(n ^ 2)
//     public int maximumDifference(int[] nums) {
//         int maxDiff = -1;
//         for(int i=0; i<nums.length; i++){
//             for(int j = i+1; j<nums.length; j++){
//                 if(nums[j] > nums[i]){
//                     maxDiff = Math.max(maxDiff, nums[j] - nums[i]);
//                 }
//             }
//         }
//         return maxDiff;
//     }
// }

//

public class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int minElement = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i] > minElement){
                maxDiff = Math.max(maxDiff, nums[i] - minElement);
            }
            else{
                minElement = nums[i];
            }
        }
        return maxDiff;
    }
}