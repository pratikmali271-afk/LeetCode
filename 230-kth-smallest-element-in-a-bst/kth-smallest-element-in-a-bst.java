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
    public List<Integer> inorder(TreeNode root, List<Integer> lst){
        if(root == null) return lst;
    
        inorder(root.left, lst);
        lst.add(root.val);
        inorder(root.right, lst);

        return lst;
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> lst = new ArrayList<>();
        inorder(root, lst);
        return lst.get(k - 1);
    }
}