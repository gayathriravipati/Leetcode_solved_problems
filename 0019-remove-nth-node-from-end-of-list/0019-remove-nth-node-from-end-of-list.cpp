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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int length = 0;
        ListNode* current = head;
        while (current) {
            length++;
            current = current->next;
        }
        
        if (n > length || n <= 0) {
            return head;
        }
        
        if (length == n) {
            ListNode* temp = head;
            head = head->next;
            delete temp;
            return head;
        }
        
        current = head;
        int counter = 1;
        while (counter < length - n) {
            current = current->next;
            counter++;
        }
        
        ListNode* temp = current->next;
        current->next = current->next->next;
        delete temp;
        
        return head;
    }
};
