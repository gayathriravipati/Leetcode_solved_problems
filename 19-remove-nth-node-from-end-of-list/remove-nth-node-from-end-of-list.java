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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1){
            return null;
        }
        
        //Find length
        int cnt = 0;
        ListNode current = head;
        while(current != null){
            current = current.next;
            cnt++;
        }
        
        
        // 5 => 2 5-2 => 3
        //iterate before 3, shift pointer
        // System.out.println()
        int pointer = cnt - n;
        if(pointer == 0){
            return head.next;
        }
        int i = 0;
        current = head;
        while(i < pointer-1){
            current = current.next;
            i++;
        }
        current.next = current.next.next;
        return head;
    }
}