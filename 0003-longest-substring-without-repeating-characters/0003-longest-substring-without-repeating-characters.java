class Solution {
    public int lengthOfLongestSubstring(String s) {
        int stringLength = s.length();
        if(stringLength == 0){
            return 0;
        }

        HashSet<Character> uniqueChars = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;

        while(j < stringLength){
            if(uniqueChars.contains(s.charAt(j))){
                // System.out.println("hii");
                maxLen = Math.max(j-i, maxLen);
                // System.out.println(maxLen + "len");
                while(uniqueChars.contains(s.charAt(j)) && i < stringLength){
                    uniqueChars.remove(s.charAt(i));
                    i++;
                }
                // System.out.println(i + "i");
            }

            uniqueChars.add(s.charAt(j));
            // System.out.println(maxLen + " " + s.charAt(j));
            j++;
        }
        maxLen = Math.max(j-i, maxLen);
        return maxLen;
    }
}