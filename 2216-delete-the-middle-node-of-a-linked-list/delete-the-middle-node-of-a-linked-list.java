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
    public ListNode deleteMiddle(ListNode head) {
        
        if(head.next == null){
            return null;
        }
        
        
        //Find len of a linkedlist
        ListNode current = head;
        int len = 0;
        while(current != null){
            len++;
            current = current.next;
        }
        int mid = len / 2;
        int cnt = 0;
        
         current = head;
        while(cnt < mid - 1){
            current = current.next;
            cnt++;
        }
        
        current.next = current.next.next;
        return head;
    }
}