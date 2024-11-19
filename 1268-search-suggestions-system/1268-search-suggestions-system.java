class Solution {
    List<List<String>> res = new ArrayList<>();
    TrieNode root;

    public void buildTrie(String word, TrieNode node) {
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new TrieNode();
        for (String word : products) {
            buildTrie(word, root);
        }

        // Generate suggestions for each prefix of the search word
        StringBuilder sb = new StringBuilder();
        TrieNode node = root;
        for (char ch : searchWord.toCharArray()) {
            sb.append(ch);
            if (node != null && node.children.containsKey(ch)) {
                node = node.children.get(ch);
                res.add(getWords(node, sb.toString()));
            } else {
                res.add(new ArrayList<>()); // No suggestions if prefix doesn't exist
                node = null; // Stop further traversal
            }
        }
       
         return res;
    }

    // Method to get all words starting from the current TrieNode
    public List<String> getWords(TrieNode node, String prefix) {
        List<String> subGroup = new ArrayList<>();
        dfs(node, new StringBuilder(prefix), subGroup);
        return subGroup;
    }

    // Depth-first search to collect words from the Trie
    public void dfs(TrieNode node, StringBuilder sb, List<String> subGroup) {
        if (subGroup.size() == 3) return; // Limit to top 3 suggestions
        if (node.isEnd) {
            subGroup.add(sb.toString());
        }
        for (char ch : node.children.keySet()) {
            sb.append(ch);
            dfs(node.children.get(ch), sb, subGroup);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }
    }
}

// Definition for TrieNode
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
        children = new TreeMap<>(); 
        isEnd = false;
    }
}
