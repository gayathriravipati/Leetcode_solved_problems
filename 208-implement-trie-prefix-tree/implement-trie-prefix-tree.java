class TrieNode{
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;
        
    public TrieNode(){
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }
    
    public TrieNode get(char ch){
        return links[ch-'a'];
    }
    
    public void setEnd(){
        isEnd = true;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
    
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }
}


class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch,new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch)){
               node = node.get(ch);   
            }
            else{
                return node == null;  //it return false here as the current node is not null nayways
            }
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(node.containsKey(ch)){
               node = node.get(ch);   
            }
            else{
                return node == null; //it return false here as the current node is not null nayways
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */