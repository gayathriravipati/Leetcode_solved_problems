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
    public ListNode partition(ListNode head, int x) {
        ListNode smallListHead = new ListNode(0);
        ListNode largeListHead = new ListNode(0);
        ListNode smallList = smallListHead;
        ListNode largeList = largeListHead;
        ListNode current = head;
        while(current!=null){
            if(current.val < x){
                smallList.next = current;
                smallList = smallList.next;
            }
            else{
                largeList.next = current;
                largeList = largeList.next;
            }
            current = current.next;
        }
        largeList.next = null;
        smallList.next = largeListHead.next;
        return smallListHead.next;
    }
}
