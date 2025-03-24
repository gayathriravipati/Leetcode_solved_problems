class Solution {
    public int countDays(int days, int[][] meetings) {
        //Base-case
        if(meetings == null || meetings.length == 0){
            return days;
        }

        //sort the meetings
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        //Merge the meetings - overlap
        List<int[]> mergedMeetings = new ArrayList<>();
        int[] current = meetings[0];

        for(int i=1; i<meetings.length; i++){
            if(meetings[i][0] <= current[1]){
                current[1] = Math.max(current[1], meetings[i][1]);
            }
            else{
                mergedMeetings.add(current);
                current = meetings[i];
            }
        }
        mergedMeetings.add(current);

        int availableDays = 0;

        // Free days before the first meeting
        if (mergedMeetings.get(0)[0] > 1) {
            availableDays += mergedMeetings.get(0)[0] - 1;
        }

        // Free days between merged meetings
        for (int i = 1; i < mergedMeetings.size(); i++) {
            availableDays += mergedMeetings.get(i)[0] - mergedMeetings.get(i - 1)[1] - 1;
        }

        // Free days after the last meeting
        if (mergedMeetings.get(mergedMeetings.size() - 1)[1] < days) {
            availableDays += days - mergedMeetings.get(mergedMeetings.size() - 1)[1];
        }

        return availableDays;
    }
}