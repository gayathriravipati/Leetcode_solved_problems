class Solution {
    //https://leetcode.com/problems/lexicographically-smallest-equivalent-string/solutions/6812060/cpp-java-python-dfs-100-beats-easy-to-un-ws91/
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, List<Character>> mappings = new HashMap<>();

        int strLen = s1.length();
        
        for(int i=0; i<strLen; i++){
            char u = s1.charAt(i);
            char v = s2.charAt(i);
            mappings.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            mappings.computeIfAbsent(v, k->new ArrayList<>()).add(u);
        }

        boolean[] visited; 
        StringBuilder result = new StringBuilder();

        for(int i=0; i<baseStr.length(); i++){
            visited = new boolean[26];
            char ch = baseStr.charAt(i);
            char res = dfs(ch, mappings, visited);
            result.append(res);
        }
        return result.toString();
    }

    public char dfs(char ch, Map<Character, List<Character>> mappings, boolean[] visited){

        visited[ch - 'a'] = true;
        char minChar = ch;
        for(char n : mappings.getOrDefault(ch, new ArrayList<>())){
            
            if(!visited[n - 'a']){
                char cnd = dfs(n, mappings, visited);
                if(cnd < minChar){
                    minChar = cnd;
                }
            }
        }
        return minChar;
    }
}