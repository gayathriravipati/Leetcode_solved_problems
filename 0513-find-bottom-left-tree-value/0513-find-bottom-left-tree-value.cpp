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
#include <vector>
#include <queue>
using namespace std;

class Solution {
public:
    int findBottomLeftValue(TreeNode* root) {
        if(root == nullptr){
            return -1;
        }
        queue<TreeNode*>q;
        vector<vector<int>>levels;
        
        q.push(root);
        
        while(!q.empty()){
            int l = q.size();
            vector<int>cv;
            
            for(int i=0;i<l;i++){
                TreeNode* current = q.front();
                q.pop();
                if(current->left){
                    q.push(current->left);
                }
                if(current->right){
                    q.push(current->right);
                }
                cv.push_back(current->val);
            }
            levels.push_back(cv);
        }
       return levels.back()[0];
    }
};
