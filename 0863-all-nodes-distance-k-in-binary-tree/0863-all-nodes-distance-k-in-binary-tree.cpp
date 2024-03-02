/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void mapparent(TreeNode* root,map<TreeNode*,TreeNode*>&parent){
        if (!root) return;
        queue<TreeNode*>q;
        q.push(root);
        while(!q.empty()){
                TreeNode* te = q.front();
                q.pop();
                if(te->left!= nullptr){
                    q.push(te->left);
                    parent[te->left] = te;
                }
                if(te->right!=nullptr){
                    q.push(te->right);
                    parent[te->right] = te;
                }   
            }
        }
    
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        map<TreeNode*, TreeNode*> parent;
        mapparent(root, parent);
        unordered_set<TreeNode*> visited;
        vector<int> result;
        queue<TreeNode*> q;
        q.push(target);
        visited.insert(target);
        int distance = 1;
        
        while (!q.empty() && distance <= k) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode* current = q.front();
                q.pop();
                visited.insert(current);
                if (current->left && visited.find(current->left) == visited.end()) {
                    q.push(current->left);
                    
                }
                if (current->right && visited.find(current->right) == visited.end()) {
                    q.push(current->right);
                    // visited.insert(current->right);
                }
                if (parent.find(current) != parent.end() && visited.find(parent[current]) == visited.end()) {
                    q.push(parent[current]);
                    // visited.insert(parent[current]);
                }
            }
            distance++;
        }
        
        while(!q.empty()){
            TreeNode* te = q.front();
            q.pop();
            result.push_back(te->val);
        }
        return result;
    }
    
};