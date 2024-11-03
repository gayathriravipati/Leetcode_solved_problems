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
        ListNode slow = head;
        ListNode fast = head.next;
        Stack<Integer> half = new Stack<>();
        int maxVal = Integer.MIN_VALUE;
    
        while(fast.next != null){
            // System.out.println(slow.val);
            half.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        half.push(slow.val);
        // System.out.println(slow.val);
        slow = slow.next;
        
        while(slow != null && !half.isEmpty()){
            int val = slow.val;
            int top = half.pop();
            maxVal = Math.max(maxVal, val + top);
            // System.out.println(maxVal);
            slow = slow.next;
        }
        return maxVal;
    }
}