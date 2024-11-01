class Solution {
    public int trap(int[] height) {
        int left_max = 0;
        int right_max = 0;
        
        int i = 0;
        int j = height.length - 1;
        int maxTrap = 0;
        
        while(i < j){
            if(height[i] < height[j]){
                left_max = Math.max(left_max, height[i]);
                maxTrap = maxTrap + left_max - height[i];
                i++;
            }
            else{
                right_max = Math.max(right_max, height[j]);
                maxTrap = maxTrap + right_max - height[j];
                j--;
            }
        }
        return maxTrap;
    }
}