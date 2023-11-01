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
    void dfs(TreeNode* root, unordered_map<int, int>& counter, int& max){
        if(root==nullptr){
            return;
        }
        int a = ++counter[root->val];
        if(a > max){
            max = a;
        }
        dfs(root->left, counter,max);
        dfs(root->right, counter,max);
    }
    
    vector<int> findMode(TreeNode* root) {
        int max = 0;
        unordered_map<int, int>mp;
        dfs(root, mp, max);
        vector<int>ans;
        unordered_map<int, int>::iterator itr;
        for(itr = mp.begin();itr!=mp.end();itr++){
            if(itr->second==max){
                ans.push_back(itr->first);
            }
        }
        return ans;
    }
};