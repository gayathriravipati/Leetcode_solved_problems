/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    long long kthLargestLevelSum(TreeNode* root, int k) {
        vector<long long>v;
        queue<TreeNode*>q;
        q.push(root);
        long long sum;
        while(q.size()!=0){
            int s = q.size();
            sum = 0;
            for(int i=0;i<s;i++){
                TreeNode* x = q.front();
                sum = sum + x->val;
                
                if(x->left!=NULL){
                    q.push(x->left);
                }
                if(x->right!=NULL){
                    q.push(x->right);
                }
                q.pop();
            }
           v.push_back(sum); 
        }
        int vl = v.size();
        
        if(vl < k){
            return -1;
        }
        
        sort(v.begin(),v.end());
        //reverse(v.begin(),v.end());
        //for(int i=0)
        return v[vl-k];
    }
};