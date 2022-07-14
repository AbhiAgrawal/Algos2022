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
    public boolean isValidBST(TreeNode root) {
        
        return isValid(root, null, null);
    }
    
    
    public boolean isValid(TreeNode node, Integer upperLimit, Integer lowerLimit) {
        if (node == null) {
            return true;
        }
        
        if (upperLimit != null && node.val >= upperLimit) {
            return false;
        }
        
        if (lowerLimit != null && node.val <= lowerLimit) {
            return false;
        }
        
        return isValid(node.left, node.val, lowerLimit) && isValid(node.right, upperLimit, node.val);
    }
}
