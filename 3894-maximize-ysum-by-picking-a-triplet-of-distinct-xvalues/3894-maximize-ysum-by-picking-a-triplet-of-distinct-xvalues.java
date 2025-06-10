class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer, Integer> xMax = new HashMap<>();

        for(int i = 0; i<x.length; i++){
            xMax.put(x[i], 
            Math.max(y[i], xMax.getOrDefault(x[i], 0)));
        }

        PriorityQueue<Integer> assignedValues = new PriorityQueue<>(Comparator.reverseOrder());

        for(int v : xMax.values()){
            assignedValues.add(v);
        }

        if(assignedValues.size() < 3){
            return -1;
        }

        int sum = 0;
        for(int i=0; i<3; i++){
            sum = sum + assignedValues.poll();
        }

        return sum;
    }
}