class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int hottestTemp = 0;
        int n = temperatures.length;
        int[] res = new int[n];

        for(int i = n-1; i>=0; i--){
            int currentTemp = temperatures[i];
            if(currentTemp >= hottestTemp){
                hottestTemp = currentTemp;
                continue;
            }

            int days = 1;
            while(temperatures[i + days] <= currentTemp){
                days += res[i + days];
            }
            res[i] = days;
        }
        return res;
    }
}