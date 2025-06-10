class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> freqCnt = new HashMap<>();
        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        for(char ch : s.toCharArray()){
            freqCnt.put(ch, freqCnt.getOrDefault(ch, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : freqCnt.entrySet()){
            int val = entry.getValue();
            // System.out.println(val + " " + entry.getKey());

            if(val % 2 == 0){
                if(minEven > val){
                    minEven = val;
                }
            }
            else{
                if(maxOdd  < val){
                    maxOdd = val;
                }
            }
        }
        return maxOdd - minEven;
    }
}