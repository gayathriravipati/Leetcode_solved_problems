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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //Traverse until the below point of left
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode beforeLeft = dummy;
        int i = 1;
        while(i < left){
            beforeLeft = beforeLeft.next;
            i++;
        }
        
        //Reverse from left to right
        ListNode prev = null;
        ListNode current =  beforeLeft.next;
        
        while(i <= right){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            i++;
        }
        
        //adjust the pointers;
        beforeLeft.next.next = current;
        beforeLeft.next = prev;
        
        return dummy.next;
    }
}