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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null || k == 1){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while(true){
        ListNode kth = getKthNode(groupPrev, k);
        
        if(kth == null){
            break;
        }
            
        ListNode groupNext = kth.next;
        ListNode prev = groupNext, curr = groupPrev.next;
            
        while(curr != groupNext){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
         // very tricky
         ListNode tmp = groupPrev.next;
         groupPrev.next = prev;
         groupPrev = tmp;
        
        }
        return dummy.next;
    }
    
    public ListNode getKthNode(ListNode curr, int k){
        while(k > 0 & curr != null){
            curr = curr.next;
            k--;
        }
        return curr;
    }
}