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
        if (!root) return -1; 
        
        queue<TreeNode*> nodesQueue;
        vector<vector<int>> levels; 
        
        nodesQueue.push(root); 
        
        while (!nodesQueue.empty()) {
            int levelSize = nodesQueue.size();
            vector<int> currentLevel;
            
            for (int i = 0; i < levelSize; ++i) {
                TreeNode* current = nodesQueue.front();
                nodesQueue.pop();
                currentLevel.push_back(current->val);
                
                if (current->left) nodesQueue.push(current->left);
                if (current->right) nodesQueue.push(current->right);
            }
            
            levels.push_back(currentLevel); 
        }
        
        return levels.back()[0];
    }
};
