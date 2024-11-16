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
        //find mid point
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //reverse the mid point
        ListNode curr = slow.next;
        slow.next = null;
        
        ListNode prev = null;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        //alternatively merge from head of the last half and first half
         ListNode one = head;
         ListNode two = prev;
         ListNode t1;
         ListNode t2;
        while(two != null){
            t1 = one.next;
            t2 = two.next;
            one.next = two;
            two.next = t1;
            one = t1;
            two = t2;
        }
    }
}