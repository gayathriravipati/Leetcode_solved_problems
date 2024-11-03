class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }
        
        Set<Character> uniqueChars = new HashSet<>();
        
        int i = 0;
        int j = 0;
        int maxLen = 1;
        
        while(j < s.length()){            
            if(uniqueChars.contains(s.charAt(j))){
                
                 // System.out.println("entered");
                maxLen = Math.max(maxLen, (j-i));
                
                while(uniqueChars.contains(s.charAt(j))){
                    uniqueChars.remove(s.charAt(i));
                    i++;
                }
                
            }
            
            uniqueChars.add(s.charAt(j));
            // System.out.println(maxLen);
            j++;
        }
        maxLen = Math.max(maxLen, (j-i));
        return maxLen;
    }
}