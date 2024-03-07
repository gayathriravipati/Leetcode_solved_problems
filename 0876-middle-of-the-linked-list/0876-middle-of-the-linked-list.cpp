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
    ListNode* middleNode(ListNode* head) {
        ListNode* temp = head;
        int c = 0; 
        
        while (temp != nullptr) {
            c++;
            temp = temp->next;
        }
        
        int midIndex = c / 2;

        temp = head;
        
        for (int i = 0; i < midIndex; i++) {
            temp = temp->next;
        }
        
        return temp;
    }
};
