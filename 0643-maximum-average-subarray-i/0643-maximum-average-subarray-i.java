class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //firt set
        double sum = 0;
        for(int i = 0; i<k; i++){
            sum += nums[i];
        }
        double avg = sum / k;
        int st = 0;
        int i = k;

        while(i < nums.length){
            sum = sum - nums[st] + nums[i];
            avg = Math.max(avg, (sum / k));
            st++;
            i++;
        }
        return avg;
    }
}