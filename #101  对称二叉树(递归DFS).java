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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode leftChild,TreeNode rightChild){
        if(leftChild==null&&rightChild==null)
            return true;
        if(leftChild==null||rightChild==null)
            return false;
        if(leftChild.val!=rightChild.val)
            return false;
        return dfs(leftChild.left,rightChild.right)&&dfs(leftChild.right,rightChild.left);
    }
}
