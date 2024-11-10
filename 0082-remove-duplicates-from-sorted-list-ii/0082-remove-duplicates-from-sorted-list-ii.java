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
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pred = dummyHead;
        
        ListNode current = head;
        
        while(current != null && current.next != null){
            
            if(current.next != null && current.val == current.next.val){
                
                while(current.next != null && current.val == current.next.val){
                    current = current.next;
                }
                
                current = current.next;
                pred.next = current;
            }
            
            else{
                 pred = pred.next;
                 current = current.next;
            }
        }
        return dummyHead.next;
    }
}