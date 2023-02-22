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
    int numComponents(ListNode* head, vector<int>& nums) {
        int l = nums.size();
        set<int>s;
        for(int i=0;i<l;i++){
            s.insert(nums[i]);
        }
        ListNode* temp = head;
        int c = 0;
        int f = 0;
        while(temp!=NULL){
            if(s.find(temp->val)!=s.end()){
                if(f==0){
                    c = c + 1;
                    f = 1;
                }
            }
            else{
                f = 0;
            }
            temp = temp->next;
        }
        return c;
    }
};