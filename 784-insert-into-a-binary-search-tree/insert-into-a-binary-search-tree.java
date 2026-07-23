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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Recursive solution
        // if(root == null){
        //     return new TreeNode(val);
        // }

        // if(val < root.val)  root.left = insertIntoBST(root.left, val);
        // if(val > root.val)  root.right = insertIntoBST(root.right, val);

        // return root;

        //Iterative solution
        if(root == null) return new TreeNode(val);
        TreeNode curr = root;
        while(true){
            if(val < curr.val){
                if(curr.left == null){
                    curr.left = new TreeNode(val);
                    break;
                }
                curr = curr.left;
            } else{
                if(curr.right == null){
                    curr.right = new TreeNode(val);
                    break;
                }
                curr = curr.right;
            }
        }

        return root;
    }
}