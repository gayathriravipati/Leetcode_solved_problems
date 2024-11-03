class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = new ListNode(); 
        ListNode head = result;
        
        int carry = 0;
        
        while (head1 != null || head2 != null) {
            int val1 = (head1 != null) ? head1.val : 0;  
            int val2 = (head2 != null) ? head2.val : 0; 
            
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            head.next = new ListNode(sum % 10); 
            head = head.next; 
            
            if (head1 != null) head1 = head1.next;  
            if (head2 != null) head2 = head2.next;  
        }
        
        if (carry != 0) {
            head.next = new ListNode(carry);
        }
        
        return result.next;
    }
}
