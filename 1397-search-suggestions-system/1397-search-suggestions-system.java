class Solution {
    List<List<String>> res = new ArrayList<>();
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

        for(String word : products){
            buildTrie(word);
        }

        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        for(char ch : searchWord.toCharArray()){
            if(node != null && node.children.containsKey(ch)){
                node = node.children.get(ch);
                sb.append(ch);
                res.add(findSimilarWords(node, sb));
            }
            else{
                node = null;
                res.add(new ArrayList<>());
            }
        }
        return res;
    }

    public List<String> findSimilarWords(TrieNode node, StringBuilder sb){
        List<String> subResult = new ArrayList<>();
        getTopwords(node, sb, subResult);
        return subResult;
    }

    public void getTopwords(TrieNode node, StringBuilder sb, List<String> result){
        if(result.size() == 3){
            return;
        }

        if(node.isEnd == true){
            result.add(sb.toString());
        }

        for(char ch : node.children.keySet()){
            sb.append(ch);
            getTopwords(node.children.get(ch), sb, result);
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