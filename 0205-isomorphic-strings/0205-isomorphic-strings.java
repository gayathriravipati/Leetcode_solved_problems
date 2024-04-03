class Solution {    
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charmapping = new HashMap<>();
        Set<Character> st = new HashSet<>();

        
        if(s.length() != t.length()){
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if(charmapping.containsKey(c1)){
                if(c2 != charmapping.get(c1)){
                    return false;
                }
            }
            else{
                if(st.contains(c2)){
                    return false;
                }
                else{
                    charmapping.put(c1,c2);
                    st.add(c2);
                }
            }
        }
        
        return true;
    }
}