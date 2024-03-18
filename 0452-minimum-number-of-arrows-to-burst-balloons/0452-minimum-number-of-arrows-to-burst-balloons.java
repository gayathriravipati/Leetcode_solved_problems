import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int l = points.length;
        int c = 0;
        Arrays.sort(points, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt((int[] o) -> o[1]));
        int te = points[0][1];

        
        for(int i = 1; i < l; i++) {
            if(points[i][0] <= te) {
                te = Math.min(te, points[i][1]);
                continue;
            } else {
                c++;
                te = points[i][1];
            }
        }
        return c + 1;
    }
}
