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
    bool isEvenOddTree(TreeNode* root) {
    vector<vector<int>> levels;
    findelements(levels, root);
        
        if(root->val % 2==0){
            return false;
        }
        
        for (int i = 1; i < levels.size(); ++i) {
        if (i % 2 == 0) {            
            if(levels[i][0] % 2 == 0){
                return false;
            }
            for (int j = 1; j < levels[i].size(); ++j) {
                if (levels[i][j] <= levels[i][j - 1] || levels[i][j] % 2 == 0) {
                    return false;
                }
            }
        } 
        else {
            if(levels[i][0] % 2 == 1){
                return false;
            }
            for (int j = 1; j < levels[i].size(); ++j) {
                if (levels[i][j] >= levels[i][j - 1] || levels[i][j] % 2 != 0) {
                    return false;
                }
            }
        }
    }
    return true;
}

    
    void findelements(vector<vector<int>>&levels,TreeNode* root){
        if(!root){
            return;
        }
        queue<TreeNode*>q;
        q.push(root);
        while(!q.empty()){
            int qs = q.size();
            vector<int>ce;
            
            for(int i=0;i<qs;i++){
                TreeNode* c = q.front();
                q.pop();
                ce.push_back(c->val);
                if(c->left!=nullptr){
                    q.push(c->left);
                }
                if(c->right!=nullptr){
                    q.push(c->right);
                }
            }
            levels.push_back(ce);
        }
    }
    
};