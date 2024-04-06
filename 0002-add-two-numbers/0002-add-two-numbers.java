class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(temp % 10);
            current = current.next;
            temp /= 10;
        }

        if (temp > 0) {
            current.next = new ListNode(temp);
        }

        return dummyHead.next;
    }
}
