class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> anagramMapper = new HashMap<>();
        
        if(strs.length == 0){
            return res;
        }
        
        for(int i=0; i<strs.length; i++){
            String s = strs[i];
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            anagramMapper.computeIfAbsent(sortedStr, k->new ArrayList<>()).add(s);
        }
        
        for(List<String> mapper : anagramMapper.values()){
            res.add(mapper);
        }
        
        return res;
    }
}