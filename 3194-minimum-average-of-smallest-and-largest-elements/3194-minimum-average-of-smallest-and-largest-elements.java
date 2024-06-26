class Solution {
    public double minimumAverage(int[] nums) {
        int i = 0;
        int times = nums.length / 2;
        double avg_element = Integer.MAX_VALUE;
        
        while(i < times){
          int local_min = Integer.MAX_VALUE;
            int local_max = Integer.MIN_VALUE;
            int local_min_idx = -1;
            int local_max_idx = -1;
            for(int j=0; j<nums.length; j++){
                if(nums[j] < local_min && nums[j] != -1){
                    local_min = nums[j];
                    local_min_idx = j;
                }
                if(nums[j] > local_max && nums[j] != -1){
                    local_max = nums[j];
                    local_max_idx = j;
                }
            }
                nums[local_min_idx] = -1;
                nums[local_max_idx] = -1;
            
                double val = ((double)local_min + local_max) / 2.0; 
                if(val < avg_element){
                    avg_element = val;
                }
            i++;
        }
        return avg_element;
    }
}