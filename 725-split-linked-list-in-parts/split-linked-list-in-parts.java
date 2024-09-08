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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int totalLen = 0;
        ListNode current = head;
        
        while(current != null){
            totalLen++;
            current = current.next;
        }
        
        int eachSize = totalLen / k;
        int[] sizes = new int[k];
        int mod = totalLen % k;
        
        for(int i=0; i<k; i++){
            sizes[i] = eachSize;
            if(mod > 0){
                sizes[i] = sizes[i] + 1;
                mod--;
            }
        }
        
        ListNode[] res = new ListNode[k];
         current = head;
        int idx = 0;
        
        while(current != null){
            ListNode dummyHead = new ListNode(-1);
            ListNode temp = dummyHead;
            for(int i=0; i<sizes[idx]; i++){
                temp.next = current;
                temp = temp.next;
                current = current.next;
            }
            temp.next = null;
            res[idx] = dummyHead.next;
            idx++;
        }
        
        while(idx < k){
            res[idx] = null;
            idx++;
        }
        
        return res;
    }
}