class TrieNode {
    TrieNode[] next = new TrieNode[26];
    int cnt = 0;
}

class Trie {
    TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word) {
        //Everytime we get a new word we come to the root and start searching
        // the first layer of children for the first character and then keep proceeding further
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node.next[c - 'a'].cnt++;
            node = node.next[c - 'a'];
        }
    }

    public int count(String s) {
        TrieNode node = root;
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans += node.next[c - 'a'].cnt;
            node = node.next[c - 'a'];
        }
        return ans;
    }
}

class Solution {

    public int[] sumPrefixScores(String[] words) {
        int N = words.length;
        Trie trie = new Trie(); //initiated the root
        
        for (int i = 0; i < N; i++) {
            trie.insert(words[i]);
        }

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = trie.count(words[i]);
        }
        return scores;
    }
}
