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
    void inorder(TreeNode *node,vector<int>&res){
        if(node==NULL){
            return;
        }
        else{
            res.push_back(node->val);
            inorder(node->left,res);
            inorder(node->right,res);
        }
    }
    
    int minDiffInBST(TreeNode* root) {
        vector<int>res;
        inorder(root,res);
        int min = INT_MAX,ans;
        sort(res.begin(),res.end());
        for(int i=1;i<res.size();i++){
            if(res[i]-res[i-1] < min){
                ans = res[i]-res[i-1];
                min = ans;
            } 
        }
        return ans;
    }
};