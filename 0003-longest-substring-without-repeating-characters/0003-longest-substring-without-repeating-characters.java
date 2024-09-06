class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;
        
        if(len==0){
            return maxLen;
        }
        else if(len==1){
            return 1;
        }
        else{
            Set<Character> uniqueChar = new HashSet<>();
            int i=0, j=0;
            
            while(j <= len-1){
                if(!uniqueChar.contains(s.charAt(j))){
                    maxLen = Math.max(maxLen, (j-i) + 1);
                    uniqueChar.add(s.charAt(j));
                    j++;
                }
                else{
                    uniqueChar.remove(s.charAt(i));
                    i++;
                }
            }
                return maxLen;
            }
        }
    }
