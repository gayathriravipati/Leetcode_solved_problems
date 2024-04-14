class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, Comparator.comparingInt(arr -> arr[0]));
        int c = 1;
        int i = 0, j=1;
        
        while(j < points.length){
            if(points[j][0] - points[i][0] > w){
                c++;
                i = j;
            }
            j++;
        }
        return c;
    }
}