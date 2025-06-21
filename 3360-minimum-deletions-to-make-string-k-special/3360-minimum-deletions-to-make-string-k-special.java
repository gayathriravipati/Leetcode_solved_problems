class Solution {
    public int minimumDeletions(String word, int k) {
        int minDeletions = word.length();
        Map<Character, Integer> freqChar = new HashMap<>();

        for(char ch : word.toCharArray()){
            freqChar.put(ch, freqChar.getOrDefault(ch,0)+1);
        }

        //Now, iterate through values alone.

        for(int a : freqChar.values()){
            int temp = 0;
            for(int b : freqChar.values()){
                if(b < a){
                    temp += b;
                }
                else if(b > a + k){
                    temp += (b - (a + k));
                }
            }
            minDeletions = Math.min(minDeletions, temp);
        }
        return minDeletions;
    }
}

