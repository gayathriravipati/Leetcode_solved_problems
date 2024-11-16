class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()){
            return false;
        }
        System.out.println(s1.length() + " " +  s2.length());
        
        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();
        
        for(int i=0; i<s1.length(); i++){
            mp1.put(s1.charAt(i), mp1.getOrDefault(s1.charAt(i), 0) + 1);
            mp2.put(s2.charAt(i), mp2.getOrDefault(s2.charAt(i), 0) + 1);   
        }
        
        if(mp1.equals(mp2)){
            return true;
        }
        
        int j = 0;
        for(int i=s1.length(); i<s2.length(); i++){
            // System.out.println(j + " " + s2.charAt(j) + " " + i + " " + s2.charAt(i));
            mp2.put(s2.charAt(j), mp2.get(s2.charAt(j)) - 1);
            
            if(mp2.get(s2.charAt(j)) == 0){
                mp2.remove(s2.charAt(j));
            }
            
            j++;
            mp2.put(s2.charAt(i), mp2.getOrDefault(s2.charAt(i), 0) + 1);
            if(mp1.equals(mp2)){
                return true;
            }
        }
        return false;
    }
}