class Solution {
    public int minimumIndex(List<Integer> nums) {
        int x = nums.get(0);
        int xCnt = 0;
        int cnt = 0;
        int n = nums.size();

        //Finding the major element
        for(int num : nums){
            if(num == x){
                cnt++;
            }
            else{
                cnt--;
            }

            if(cnt == 0){
                x = num;
                cnt = 1;
            }
        }

        //Finding the freq of the major element
        for(int num : nums){
            if(num == x){
                xCnt++;
            }
        }

        cnt = 0;
        for(int idx = 0; idx < nums.size(); idx++){
            if(nums.get(idx) == x){
               cnt++;
               int remainingCount = xCnt - cnt;
                if (cnt * 2 > idx + 1 && remainingCount * 2 > n - idx - 1) {
                    return idx;
                }
            }
        }
    return -1;
    }
}