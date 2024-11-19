class TrieNode{
    Map<Character, TrieNode> children;
    boolean isEnd;
    
    public TrieNode(){
        children = new HashMap<>();
        isEnd = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.children.containsKey(ch)){
                node.children.put(ch, new TrieNode());
            }
            node =  node.children.get(ch);
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
         TrieNode node = root;
         return searchInNode(word, 0, node);
    }
    
    public boolean searchInNode(String word, int idx, TrieNode node){
        if(idx == word.length()){
            return node.isEnd;
        }
        
        if(word.charAt(idx) == '.'){
            for(char ch : node.children.keySet()){
                if(searchInNode(word, idx + 1, node.children.get(ch))){
                    return true;
                }
            }
            return false;
        }
        else{
            if(!node.children.containsKey(word.charAt(idx))){
                return false;
            }
            else{
                node = node.children.get(word.charAt(idx));
            }
        }
        return searchInNode(word, idx + 1, node);
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */