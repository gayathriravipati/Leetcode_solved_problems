class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxWater = Integer.MIN_VALUE;
        
        while(i < j){
            if(height[i] < height[j]){
                maxWater = Math.max(maxWater, (j-i) * Math.min(height[i], height[j]));
                i++;
            }
            else{
                 maxWater = Math.max(maxWater, (j-i) * Math.min(height[i], height[j]));
                j--;
            }
        }
        
        return maxWater;
    }
}