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
    int tc = 0;
    
    void preorder(TreeNode* root, int cn){
        if(root != NULL){
            cn = cn*10 + root->val;
            if(root->left == NULL && root->right == NULL){
                tc = tc + cn;
            }
            preorder(root->left, cn);
            preorder(root->right, cn);
        }
    }
    
    int sumNumbers(TreeNode* root) {
        preorder(root,0);
        return tc;
    }
};