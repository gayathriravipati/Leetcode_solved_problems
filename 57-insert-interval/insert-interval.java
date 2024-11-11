class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> pointsList = new ArrayList<>();
        
        int X = newInterval[0];
        int Y = newInterval[1];
        boolean flag = false;
        
        for(int i = 0; i< intervals.length; i++){
            if(!flag){
                if(intervals[i][1] < X){
                    pointsList.add(new int[] {intervals[i][0], intervals[i][1]});
                }
                else{
                    if(intervals[i][1] >= X && intervals[i][0] <= Y){
                        X = Math.min(X, intervals[i][0]);
                        Y = Math.max(Y, intervals[i][1]);
                    }
                    else{
                         pointsList.add(new int[] {X,Y});
                         pointsList.add(new int[] {intervals[i][0], intervals[i][1]});
                         flag = true;
                    }
                }
            }
            else{
                pointsList.add(new int[] {intervals[i][0], intervals[i][1]});
            }
        }
        
        if (!flag) {
            pointsList.add(new int[] {X, Y});
        }
        
        int[][] result = new int[pointsList.size()][2];
        for (int i = 0; i < pointsList.size(); i++) {
            result[i][0] = pointsList.get(i)[0];
            result[i][1] = pointsList.get(i)[1];
        }
        
        return result;
        
    }
}