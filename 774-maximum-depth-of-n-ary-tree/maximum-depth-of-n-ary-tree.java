/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                Node node = q.poll();
                if(!node.children.isEmpty()){
                    for(Node c : node.children){
                        q.add(c);
                    }
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}