class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> anagrams = new HashMap<>();
        
        for(String str : strs){
            char[] currentString = str.toCharArray();
            Arrays.sort(currentString);
            String sortedStr = new String(currentString);
            anagrams.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for(List<String> str : anagrams.values()){
            res.add(str);
        }
        
        return res;
    }
}