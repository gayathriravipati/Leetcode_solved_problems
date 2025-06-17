class Solution {
    public boolean closeStrings(String word1, String word2) {
        //let's build hashmap to both the strings
        //both hashmaps should have same keys and overall same values();

        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();

        //O(n)
        for(char c : word1.toCharArray()){
            mp1.put(c, mp1.getOrDefault(c, 0) + 1);
        }

        //O(n)
        for(char c : word2.toCharArray()){
            mp2.put(c, mp2.getOrDefault(c, 0) + 1);
        }

        HashMap<Integer, Integer> v1 = new HashMap<>();
        HashMap<Integer, Integer> v2 = new HashMap<>();

        for (char c : mp1.keySet()) { 
            if(!mp2.containsKey(c)){
                return false;
            }
            else{
                v1.put(mp1.get(c), v1.getOrDefault(mp1.get(c), 0) + 1);
                v2.put(mp2.get(c), v2.getOrDefault(mp2.get(c), 0) + 1);
            }
        }
        
        if(!v1.equals(v2)){
            return false;
        }

    
        v1 = new HashMap<>();
        v2 = new HashMap<>();
        
        for (char c : mp2.keySet()) { 
            if(!mp1.containsKey(c)){
                return false;
            }
            else{
                v1.put(mp1.get(c), v1.getOrDefault(mp1.get(c), 0) + 1);
                v2.put(mp2.get(c), v2.getOrDefault(mp2.get(c), 0) + 1);
            }
        }

        return true;

    }
}