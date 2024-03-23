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
    public void reorderList(ListNode head) {
        ListNode dummy  = new ListNode(-1);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode current = slow.next;
        slow.next = null;
        
        
        ListNode prev = null;
        ListNode next;
        
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        ListNode one = head;
        ListNode two =  prev;
        ListNode t1,t2;
        
        while(two!=null){
            t1 = one.next;
            t2 = two.next;
            one.next = two;
            two.next = t1;
            one = t1;
            two = t2;
        }
        
    }
}