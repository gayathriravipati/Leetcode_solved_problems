class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int start = 0;
        int end = len-1;
        int area = Integer.MIN_VALUE;

        while(start < end){
            // System.out.println(start + " " + end + "ddd");
            int minEnd =  Math.min(height[start], height[end]);
            int diff = end - start;
            // System.out.println(minEnd + " " + diff);
            area = Math.max(area, (minEnd * diff));
            if(height[start] < height[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return area;
    }
}