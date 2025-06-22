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
    public ListNode deleteMiddle(ListNode head) {
        // 1. let us find the num of nodes and find middle
        // 2. iterate until middle - 1 
        // 3. change the pointer from the current to next.next and return head

        if (head == null || head.next == null) {
            return null;
        }

        ListNode dummy = head;
        int len = 0;
        
        while(dummy != null){
            len++;
            dummy = dummy.next;
        }

        int middle = len / 2;
        int cnt = 0;
        dummy = head;

        while(cnt < middle-1){
            dummy = dummy.next;
            cnt++;
        }

        dummy.next = dummy.next.next;
        return head;
    }
}