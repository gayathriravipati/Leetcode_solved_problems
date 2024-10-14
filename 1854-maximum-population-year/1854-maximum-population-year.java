class Solution {
    public int maximumPopulation(int[][] logs) {
        TreeMap<Integer, Integer> yearsCnt = new TreeMap<>();
        for(int log[] : logs){
            int start = log[0];
            int end = log[1];
            for(int i=start; i<end; i++){
                yearsCnt.put(i, yearsCnt.getOrDefault(i, 0) + 1);
            }
        }
        
        int currentMax = 0;
        int year = 0;
        
        for(Map.Entry<Integer, Integer> entry : yearsCnt.entrySet()){
            int val = entry.getValue();
            if(val > currentMax){
                year = entry.getKey();
                currentMax = val;
            }
        }
        return year;
    }
}