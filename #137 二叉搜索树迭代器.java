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
class BSTIterator {

    private List<Integer> interatorList;
    private int curIndex;

    public BSTIterator(TreeNode root) {
        curIndex=0;
        interatorList=new ArrayList<>();
        inOrderTraversal(root,interatorList);
    }
    
    public int next() {
        return interatorList.get(curIndex++);
    }
    
    public boolean hasNext() {
        return curIndex<interatorList.size();
    }

    private void inOrderTraversal(TreeNode root,List<Integer> list){
        if(root.left!=null){
            inOrderTraversal(root.left,list);
        }
        list.add(root.val);
        if(root.right!=null){
            inOrderTraversal(root.right,list);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */