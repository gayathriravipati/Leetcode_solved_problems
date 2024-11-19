class Solution {
     List<List<String>>  res = new ArrayList<>();
     TrieNode root = new TrieNode();
    
    public void buildTrie(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }
    
     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
         
        for(String p : products){
            buildTrie(p);
        }
         
        //search the matching words for every character
         TrieNode node = root;
         StringBuilder sb = new StringBuilder();
         
        for(char ch : searchWord.toCharArray()){
            if(node != null && node.children.containsKey(ch)){
                node = node.children.get(ch);
                sb.append(ch);
                res.add(getWords(node, sb));
            }
            else{
                res.add(new ArrayList<>());
                node = null;
            }
        }
         return res;
    }
    
    public List<String> getWords(TrieNode node, StringBuilder sb){
        List<String> subGroup = new ArrayList<>();
        explore(node, sb, subGroup);
        return subGroup;
    }
    
    public void explore(TrieNode node, StringBuilder sb, List<String> subGroup){
        if(subGroup.size() == 3){
            return;
        }
        
        if(node.isEnd == true){
            subGroup.add(sb.toString());
        }
        
        for(char ch : node.children.keySet()){
            sb.append(ch);
            explore(node.children.get(ch), sb, subGroup);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
}

class TrieNode{
    Map<Character, TrieNode> children;
    boolean isEnd;
    
    public TrieNode(){
        children = new TreeMap<>();
        isEnd = false;
    }
}