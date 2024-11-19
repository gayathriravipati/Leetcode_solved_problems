class Solution {
    char[][] board;
    int rows;
    int cols;
    List<String> matchedWords = new ArrayList<>();
    
    public void buildTrie(String p, TrieNode node){
        for(char ch : p.toCharArray()){
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.word = p;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rows = board.length;
        this.cols =  board[0].length;
        
        //Build Trie
        TrieNode root = new TrieNode();
        TrieNode node = root;
        
        for(String p : words){
            buildTrie(p, node);
        }
        
        //Finding words in board;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(node.children.containsKey(board[i][j])){
                    explore(node.children.get(board[i][j]), i, j, node);
                }
            }
        }
        return matchedWords;
    }
    
    public void explore(TrieNode node, int r, int c, TrieNode parent){
        
        if(node.word != null){
            matchedWords.add(node.word);
            node.word = null;
        }
        
        int[][] dirs = {
            {1,0}, {-1,0}, {0, 1}, {0, -1}
        };
        
        char letter = board[r][c];
        board[r][c] = '#';
        
        for(int i = 0; i < 4; i++){
            int nr = r + dirs[i][0];
            int nc = c + dirs[i][1];
            
            if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || board[nr][nc] == '#'){
                continue;
            }
            
            if(node.children.containsKey(board[nr][nc])){
                explore(node.children.get(board[nr][nc]), nr, nc, node);
            }
        }
        
        board[r][c] = letter;
        
        if(node.children.isEmpty()){
            parent.children.remove(letter);
        }   
    }
}

class TrieNode{
    Map<Character, TrieNode> children;
    String word;
    
    public TrieNode(){
        children = new HashMap<>();
        word = null;
    }
}