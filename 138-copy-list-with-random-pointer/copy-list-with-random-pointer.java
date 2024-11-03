/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        
        Map<Node, Node> mappings = new HashMap<>();
        Node res = new Node(head.val);
        
        mappings.put(head, res);
        
        Node current = head;
        
        while(current != null){
            Node on = current.next;
            Node or = current.random;
            
            mappings.putIfAbsent(current, new Node(current.val));
            
            if(on != null){
            mappings.putIfAbsent(on, new Node(current.next.val));
            }
            
            if(or != null){
                mappings.putIfAbsent(or, new Node(current.random.val));
            }
            
            
            Node t = mappings.get(current);
            t.next = mappings.get(on);
            t.random = mappings.get(or);
            
            t = t.next;
            current = current.next;
        }
        return res;
    }
}