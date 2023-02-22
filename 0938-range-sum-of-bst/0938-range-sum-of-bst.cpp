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
    int c = 0;
    int rangeSumBST(TreeNode* root, int low, int high){
        //cout<<"Hello"<<endl;
        if(root==NULL){
            return c;
        }
            if(low <= root->val && root->val <= high){
                c = c + root->val;
                //cout<<root->val<<endl;
                rangeSumBST(root->right,low,high);
                rangeSumBST(root->left,low,high);
            }
            
            else if(root->val < low){
               rangeSumBST(root->right,low,high);
            }
            
            else if(root->val > high){
                //cout<<rangeSumBST(root->left, low, high)<<endl;
                rangeSumBST(root->left,low,high);
            }
            //cout<<c<<endl;
        return c;
    }
};