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
    public int findLength(ListNode list){
        int c = 1;
        ListNode curr = list;
        while(curr!=null){
            curr = curr.next;
            c++;
        }
        return c;
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        int l1 = findLength(list1);
        int l2 = findLength(list2);
        
        ListNode one = list1;
        ListNode two = list2;
        int i=0,j=0;
        
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        
        while(one !=null && two!=null){
            if(one.val<=two.val){
                result.next = one;
                result = result.next;
                one = one.next;
            }
            else{
                result.next = two;
                result = result.next;
                two = two.next;
            }
       }
        
        if(one!=null){
            result.next = one;
            result = result.next;
        }
        else{
            result.next = two;
            result = result.next;
        }
        return dummy.next;
    }
}