class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Character,Integer>charMap = new HashMap<>();
        //hashmap has higher char and its first occurrence index
        for(int i = 0;i < word.length(); i++){
            Character ch = word.charAt(i);
            if(Character.isUpperCase(ch) && !charMap.containsKey(ch)){
                charMap.put(ch,i);
            }
        }
        
        int count = 0;
       Set<Character>st = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            char lowercaseCh = Character.toLowerCase(ch);
            char uppercaseCh = Character.toUpperCase(ch);
            
            if (ch.equals(lowercaseCh) && charMap.containsKey(uppercaseCh)) {
                    if(charMap.get(uppercaseCh) > i) {
                        st.add(lowercaseCh);
                    }
                    else{
                        st.remove(lowercaseCh);
                        charMap.remove(uppercaseCh);
                    }
            }
        }
        return st.size();
    }
}