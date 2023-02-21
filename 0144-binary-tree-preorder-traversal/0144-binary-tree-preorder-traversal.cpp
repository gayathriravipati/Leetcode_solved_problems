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
   // vector<int> res;
    vector<int> preorderTraversal(TreeNode* root) {
        
//         if(root == NULL){
//             return res;
//         }
        
//         res.push_back(root->val);
//         preorderTraversal(root->left);
//         preorderTraversal(root->right);

//         return res;
        
        vector<int>po;
        if(root==NULL){
            return po;
        }
        else{
            stack<TreeNode*>st;
            st.push(root);
            while(!st.empty()){
                root = st.top();
                st.pop();
                if(root->right!=NULL){
                    st.push(root->right);
                }
                if(root->left!=NULL){
                    st.push(root->left);
                }
                po.push_back(root->val);
            }
        }
        return po;
        
    }
};