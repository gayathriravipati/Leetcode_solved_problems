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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> uniqueNums = new HashSet<>();
        for(int num : nums){
            uniqueNums.add(num);
        }
        
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        ListNode current = head;
        dummyHead.next = head;
        
        while(current != null){
            if(!uniqueNums.contains(current.val)){
                prev.next = current;
                prev = current;
            }
            else{
                prev.next = current.next;
            }
            current = current.next;
        }
        return dummyHead.next;
    }
}