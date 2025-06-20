class Solution {
    public int partitionArray(int[] nums, int k) {
        //sort the array nums
        //have the minimum element as the first element, cnt = 1;
        //while not reaching the end of array and c.e - e <= k => run the loop 

        int cnt = 0;
        int idx = 0;
        int len = nums.length;
        Arrays.sort(nums);
        int min_element = nums[0];

        while(idx < len){
            min_element = nums[idx];
            cnt++;
            while(idx < len && nums[idx] - min_element <= k){
                idx++;
            }
        }
        return cnt; 
    }
}

//P.S : To the future me, learn to write neat code. Below code is from the editorial which avoids nested loops and less constants

// class Solution {

//     public int partitionArray(int[] nums, int k) {
//         Arrays.sort(nums);
//         int ans = 1;
//         int rec = nums[0];
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] - rec > k) {
//                 ans++;
//                 rec = nums[i];
//             }
//         }
//         return ans;
//     }
// }