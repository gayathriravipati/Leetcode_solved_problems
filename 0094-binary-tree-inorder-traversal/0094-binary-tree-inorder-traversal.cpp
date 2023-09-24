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
    vector<int>res;
    void find(TreeNode* root){
        if(root == NULL){
            return;
        }
        if(root->left != NULL){
            find(root->left);
        }
        res.push_back(root->val);
        if(root->right != NULL){
            find(root->right);
        }
    }
    vector<int> inorderTraversal(TreeNode* root) {
        find(root);
        return res;
    }
};