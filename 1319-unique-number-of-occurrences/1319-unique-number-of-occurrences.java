class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : arr){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        Set<Integer> uniqueElements = new HashSet<>();
        for(int v : freq.values()){
            if(uniqueElements.contains(v)){
                return false;
            }
            uniqueElements.add(v);
        }
        return true;
    }
}