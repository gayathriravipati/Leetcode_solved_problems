class Solution {
    public int countDays(int days, int[][] meetings) {
        if (meetings == null || meetings.length == 0) {
            return days; 
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedMeetings = new ArrayList<>();
        int[] current = meetings[0];
        mergedMeetings.add(current);

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] <= current[1]) {  
                current[1] = Math.max(current[1], meetings[i][1]);
            } else {
                current = meetings[i];
                mergedMeetings.add(current);
            }
        }

        int availableDays = 0;
        int lastEnd = 0;

        for (int[] interval : mergedMeetings) {
            availableDays += interval[0] - lastEnd - 1; 
            lastEnd = interval[1]; 
        }

        availableDays += days - lastEnd;

        return availableDays;


    }
}