class Solution {
    public long minimumSteps(String s) {
        List<Integer> indices = new ArrayList<>();
        int targetindex = 0;
        long totalSwaps = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                indices.add(i);
            }
        }
        
        for(int idx : indices){
            totalSwaps += (idx - targetindex);
            targetindex++;
        }
        
        return totalSwaps;
    }
}