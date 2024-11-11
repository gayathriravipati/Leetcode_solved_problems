class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //sort based on start time
        int pointX = intervals[0][0];
        int pointY = intervals[0][1];
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int cnt = 0;
        int prevEndTime = Integer.MIN_VALUE;
        
        for(int i = 0; i < intervals.length; i++){
            int X = intervals[i][0];
            int Y = intervals[i][1];
            
            if(X >= prevEndTime){
               prevEndTime = Y; //current interval end-time
            }
            else{
                //Dont change
                cnt++;
            }
        }
        return cnt;
    }
}