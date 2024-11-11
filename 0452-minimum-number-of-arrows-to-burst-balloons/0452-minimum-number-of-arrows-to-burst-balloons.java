class Solution {
    public int findMinArrowShots(int[][] points) {
        //sort based on X0
        
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        
        // for(int i = 0; i<points.length; i++){
        //     System.out.println(points[i][0] + " " + points[i][1]);
        // }
        
        
        int endPnt = points[0][1];
        int cnt = 1;
        
        for(int i = 1; i<points.length; i++){
            if(points[i][0] > endPnt){
                endPnt = points[i][1];
                cnt++;
            }
        }
        
        return cnt;
    }
}