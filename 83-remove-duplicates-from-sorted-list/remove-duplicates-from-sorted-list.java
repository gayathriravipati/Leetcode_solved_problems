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
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode slow = head;
        ListNode current = head;
        
        while(current.next != null){
            if(current.next != null && current.val == current.next.val){
                current = current.next;
            }
            else{
                current = current.next;
                slow.next = current;
                slow = slow.next;
            }
        }
        slow.next = current.next;
        return head;
    }
}