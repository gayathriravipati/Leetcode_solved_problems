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

//Solution from editorial, space and time can be same, but better way of writing and it can cover edge cases.




// class Solution {

//     public boolean closeStrings(String word1, String word2) {
//         if (word1.length() != word2.length()) {
//             return false;
//         }
//         Map<Character, Integer> word1Map = new HashMap<>();
//         Map<Character, Integer> word2Map = new HashMap<>();
//         for (char c : word1.toCharArray()) {
//             word1Map.put(c, word1Map.getOrDefault(c, 0) + 1);
//         }
//         for (char c : word2.toCharArray()) {
//             word2Map.put(c, word2Map.getOrDefault(c, 0) + 1);
//         }
//         if (!word1Map.keySet().equals(word2Map.keySet())) {
//             return false;
//         }
//         List<Integer> word1FrequencyList = new ArrayList<>(word1Map.values());
//         List<Integer> word2FrequencyList = new ArrayList<>(word2Map.values());
//         Collections.sort(word1FrequencyList);
//         Collections.sort(word2FrequencyList);
//         return word1FrequencyList.equals(word2FrequencyList);
//     }
// }