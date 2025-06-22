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
    public int pairSum(ListNode head) {

        // if(head.next.next == null){
        //     return head.val + head.next.val;
        // }
        
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        ListNode neutralPtr = head;

        //To reach 
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        // slowPtr = slowPtr.next;

        ListNode prev = null;
        ListNode current = slowPtr;

        while(current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        int maxSum = Integer.MIN_VALUE;
        while(prev != null){
            maxSum = Math.max(maxSum, prev.val + neutralPtr.val);
            prev = prev.next;
            neutralPtr = neutralPtr.next;
        }
        return maxSum;
    }
}