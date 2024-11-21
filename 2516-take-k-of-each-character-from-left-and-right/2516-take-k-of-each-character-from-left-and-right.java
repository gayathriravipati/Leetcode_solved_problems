class Solution {
    public int takeCharacters(String s, int k) {
        int[] charCount = new int[3]; 
        int[] currCount = new int[3]; 
        
        int len = s.length();
        if (k == 0) {
            return 0; 
        }
        
        for (int i = 0; i < len; i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 3; i++) {
            if (charCount[i] < k) {
                return -1;
            }
        }
        
        int left = 0, right = 0, maxLen = 0;
        
        while (right < len) {
            currCount[s.charAt(right) - 'a']++;
            
            while (left <= right && 
                   (charCount[0] - currCount[0] < k || 
                    charCount[1] - currCount[1] < k || 
                    charCount[2] - currCount[2] < k)) {
                currCount[s.charAt(left) - 'a']--;
                left++;
            }
            
            maxLen = Math.max(maxLen, (right - left) + 1);
            right++;
        }
        
        return len - maxLen;
    }
}
