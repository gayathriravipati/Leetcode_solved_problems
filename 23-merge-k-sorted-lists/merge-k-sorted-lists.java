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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0){
            return null;
        }
        
        while(lists.length > 1){
            
            List<ListNode> mergeLists = new ArrayList<>();

            for(int i = 0; i<lists.length; i += 2){
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1 < lists.length) ? lists[i+1] : null;
                
                ListNode res = mergeNodes(l1, l2);
                
                // while(res != null){
                //     System.out.println(res.val);
                //     res = res.next;
                // }
                
                mergeLists.add(res); 
            }

           lists = new ListNode[mergeLists.size()];
            
            for(int i = 0; i< mergeLists.size(); i++){
                lists[i] = mergeLists.get(i);
            }
            
        }
        
        // ListNode res = lists[0];
        // while(res != null){
        //     System.out.println(res.val);
        //     res = res.next;
        // }
        
            return lists[0];
    }
    
    private ListNode mergeNodes(ListNode l1, ListNode l2){
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while(l1 != null && l2 != null){
            
            if(l1.val < l2.val){
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }
            
            else{
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
            
        }
        
       curr.next =  l1 != null ? l1 : l2;
      
       return  dummy.next;
    }
}