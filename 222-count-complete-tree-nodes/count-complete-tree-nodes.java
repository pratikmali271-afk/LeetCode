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
 * }
 *     }
 */
class Solution {
    // int count = 0;
    // public void inorder(TreeNode root){
    //     if(root == null) return;
    //    // if(root.left == null && root.right == null) return;

    //     inorder(root.left);
    //     count++;
    //     inorder(root.right);
    // }
    public int leftHeight(TreeNode root){
        int count = 0;
        while(root != null){
            count++;
            root = root.left;
        }
        return count;
    }
    public int rightHeight(TreeNode root){
        int count = 0;
        while(root != null){
            count++;
            root = root.right;
        }
        return count;
    }
    public int countNodes(TreeNode root) {
        // inorder(root);
        // return count;
        if(root == null) return 0;

        int left = leftHeight(root);
        int right = rightHeight(root);

        if(left == right) return (int) Math.pow(2, left) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}