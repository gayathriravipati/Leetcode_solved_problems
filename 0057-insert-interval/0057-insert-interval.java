class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultlist = new ArrayList<>();
        int newstart = newInterval[0];
        int newend = newInterval[1];
        int i = 0;
        
        while(i<intervals.length && intervals[i][1] < newstart){
            resultlist.add(intervals[i]);
            i++;
        }
        
        while(i<intervals.length && intervals[i][0] <= newend){
             newstart = Math.min(newstart, intervals[i][0]);
             newend = Math.max(newend, intervals[i][1]);
             i++;
        }
        resultlist.add(new int[]{newstart, newend});
        
        
        while(i<intervals.length){
            resultlist.add(intervals[i]);
            i++;
        }
        
        int[][] resultArray = new int[resultlist.size()][2];
        for (int j = 0; j < resultlist.size(); j++) {
            resultArray[j] = resultlist.get(j);
        }
        return resultArray;
        
    }
}