/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //Iterate the linkedlist and find non-duplicate nodes => TreeMap
        Map<Integer, Integer> uniqueNode = new TreeMap<>();
        ListNode current = head;
        
        while(current != null){
            uniqueNode.put(current.val, uniqueNode.getOrDefault(current.val, 0) + 1);
            current = current.next;
        }
        
        ListNode res = new ListNode();
         current = res;
        
        for(Map.Entry<Integer, Integer> entry : uniqueNode.entrySet()){
            if(entry.getValue() == 1){
                current.next = new ListNode(entry.getKey());
                current = current.next;
            }
        }
        
        return res.next;
    }
}