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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        int temp = 0;
        
        while(l1!=null || l2!=null){
            if(l1!=null){
                temp += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                temp += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(temp % 10);
            temp = temp / 10;
            current = current.next;
        }
        
        if(temp!=0){
            current.next = new ListNode(temp % 10);
            current = current.next;
        }
        return dummyNode.next;
    }
}