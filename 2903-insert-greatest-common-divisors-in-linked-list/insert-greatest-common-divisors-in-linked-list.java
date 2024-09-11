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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode dummyHead = res;
        if(head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        res.next = first;
        res = res.next;
        
        while(first != null && second != null){
            int num1 = first.val;
            int num2 = second.val;
            int gcd = findDivisor(num1, num2);
            res.next = new ListNode(gcd);
            res = res.next;
            res.next = second;
            res = res.next;
                    
            first =  second;
            second = second.next;
        }
        return dummyHead.next;
    }
    
    private int findDivisor(int num1,int num2){
        int range = Math.min(num1, num2);
        int gcd = 1;
        int i=1;
        for(i=1; i<= range; i++){
            if(num1 % i==0 && num2 % i==0){
                gcd = i;
            }
        }
        System.out.println(num1 + " " + num2 + " " + gcd);
        return gcd;
    }
}