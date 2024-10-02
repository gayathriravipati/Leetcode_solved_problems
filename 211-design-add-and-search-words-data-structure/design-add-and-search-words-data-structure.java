class TrieNode{
    Map<Character, TrieNode> children;
    boolean isEnd;
        
    public TrieNode(){
        children = new HashMap<>();
        isEnd = false;
    }
}

class WordDictionary {
    TrieNode trie;
    public WordDictionary() {
        trie = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = trie;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.children.containsKey(ch)){
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word, trie);   
    }
    
    public boolean searchInNode(String word, TrieNode node){
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for (char x : node.children.keySet()){
                    TrieNode child = node.children.get(x);
                    if (searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            }else{
                if(!node.children.containsKey(ch)){
                    return false;
                }
                else{
                   node = node.children.get(ch); 
                }
            }
        }
        return node.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */