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
    public int secondMinValue=-1;
    public int rootValue=-1;
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)
            return -1;
        rootValue=root.val;
        dfsTree(root);
        return secondMinValue;
    }

    private void dfsTree(TreeNode curRoot){
        if(curRoot==null)
            return;
        if(curRoot.val>secondMinValue&&secondMinValue!=-1)
        //说明当前已经找到一个大于rootValue的节点值
        //并且当前dfs的子树所有节点值比找到的secondValue大，下面的子树就不用搜索了
            return;
        if(curRoot.val>rootValue){
            secondMinValue=curRoot.val;
        }
        dfsTree(curRoot.left);
        dfsTree(curRoot.right);
    }

}