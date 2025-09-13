class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> freqCnt = new HashMap<>();
        int maxVowel = 0;
        int maxConsonant = 0;

        for(char ch : s.toCharArray()){
            freqCnt.put(ch, freqCnt.getOrDefault(ch, 0) + 1);
            int val = freqCnt.get(ch);
            if(isVowel(ch)){
                maxVowel = Math.max(maxVowel, val);
            }
            else{
                maxConsonant = Math.max(maxConsonant, val);
            }
        }
        return maxConsonant + maxVowel;
    }

    private boolean isVowel(Character ch){
        if(ch == 'a' || ch == 'e' ||  ch == 'i' ||  ch == 'o' ||  ch == 'u'){
            return true;
        }
        return false;
    }
}
