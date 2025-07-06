class Solution {
    public int findLucky(int[] arr) {
        int luckyNum = Integer.MIN_VALUE;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int n : arr){
            freq.put(n, freq.getOrDefault(n,0) + 1);
        }

        for(Map.Entry<Integer, Integer> mp : freq.entrySet()){
            int key = mp.getKey();
            int val = mp.getValue();

            if(key == val){
               luckyNum = Math.max(luckyNum, key); 
            }
        }

        return luckyNum == Integer.MIN_VALUE ? -1 : luckyNum;
    }
}