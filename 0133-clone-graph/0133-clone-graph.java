/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// 1. node==null => return node;
// hashmap => original => clone
// A => A', new ArrayList()
// .neighbors => n


class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        HashMap<Node, Node> clone = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        clone.put(node, new Node(node.val, new ArrayList()));
        q.add(node);
        
        while(!q.isEmpty()){
            Node n = q.poll();
            for(Node neighbor : n.neighbors){
                if(!clone.containsKey(neighbor)){
                    clone.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    q.add(neighbor);
                }
                clone.get(n).neighbors.add(clone.get(neighbor));
            }
        }
        return clone.get(node);
    }
}