/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();

            if (isMatch(node, head)) {
                return true;
            }

            if (node.left != null) {
                nodes.push(node.left);
            }
            if (node.right != null) {
                nodes.push(node.right);
            }
        }

        return false;
    }

    private boolean isMatch(TreeNode node, ListNode lst) {
        Stack<Map.Entry<TreeNode, ListNode>> s = new Stack<>();
        s.push(new HashMap.SimpleEntry<>(node, lst));

        while (!s.isEmpty()) {
            Map.Entry<TreeNode, ListNode> entry = s.pop();
            TreeNode currentNode = entry.getKey();
            ListNode currentList = entry.getValue();

            while (currentNode != null && currentList != null) {
                if (currentNode.val != currentList.val) {
                    break;
                }
                currentList = currentList.next;

                if (currentList != null) {
                    if (currentNode.left != null) {
                        s.push(
                            new HashMap.SimpleEntry<>(
                                currentNode.left,
                                currentList
                            )
                        );
                    }
                    if (currentNode.right != null) {
                        s.push(
                            new HashMap.SimpleEntry<>(
                                currentNode.right,
                                currentList
                            )
                        );
                    }
                    break;
                }
            }

            if (currentList == null) {
                return true;
            }
        }

        return false;
    }
}