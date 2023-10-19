/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        
        ListNode* prev = dummy;
        ListNode* curr = head;
        while(curr != nullptr){
            if(curr->val!=val){
                prev = prev->next;
                curr = curr->next;
            }
            else{
                prev->next = curr->next;
                delete curr;
                curr = prev->next;
            }
        }
        
        ListNode* ret = dummy->next;
        
        //head = dummy->next;
        //delete dummy;
        return ret;
    }
};