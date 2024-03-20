class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode al = null;
        ListNode bl = null;
        ListNode temp = list1;
        int c = 0;
        
        while (temp != null) {
            if (c == a) {
                al = temp;
            }
            if (c == b) {
                bl = temp;
                break;
            }
            temp = temp.next;
            c++;
        }
        
        
        temp = list1;
        while (temp.next != al) {
            temp = temp.next;
        }
        
        temp.next = list2;
        
        
        
        while (list2.next != null) {
            list2 = list2.next;
        }
        
     
        list2.next = bl.next;
    
        
        return list1;
    }
}
