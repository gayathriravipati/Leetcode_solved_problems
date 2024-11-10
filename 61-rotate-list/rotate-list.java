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
    public ListNode rotateRight(ListNode head, int k) {
        //find length
        if(head == null || head.next == null){
            return head;
        }
        
        int cnt = 0;
        ListNode current = head;
        
        while(current != null){
            cnt++;
            current = current.next;
        }
        
        //shilft the pointers k times
        
        k = k % cnt;
        while(k-- > 0){
            int i = 0;
            current = head;
            while(i++ < cnt-2){
                current = current.next;
            }
            
            ListNode newHead = current.next;
            current.next = null;
            newHead.next = head;
            head = newHead;
        }
        return head;
    }
}