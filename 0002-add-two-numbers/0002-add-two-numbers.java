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
        int carry = 0;
        ListNode res = new ListNode();
        ListNode tail = res;
        ListNode one = l1;
        ListNode two = l2;

        while(one != null || two != null || carry !=0){
            int curr = carry + (one != null ? one.val : 0)  + (two != null ? two.val : 0);

            carry = curr / 10;
            curr = curr % 10;
            
            tail.next = new ListNode(curr);
            tail = tail.next;

            if(one != null){
                one = one.next;
            }

            if(two != null){
                two = two.next;
            }
        }

        return res.next;
    }
}