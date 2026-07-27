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

 // Method 1
// class Solution {

//     List<TreeNode> nodes = new ArrayList<>();
//     List<Integer> values = new ArrayList<>();

//     public void inorder(TreeNode root) {
//         if (root == null) return;

//         inorder(root.left);
//         nodes.add(root);
//         values.add(root.val);
//         inorder(root.right);
//     }

//     public void recoverTree(TreeNode root) {
//         inorder(root);

//         Collections.sort(values);

//         for (int i = 0; i < nodes.size(); i++) {
//             nodes.get(i).val = values.get(i);
//         }
//     }
// }

//Method 2 expected
class Solution {
    private TreeNode first;
    private TreeNode last;
    private TreeNode prev;

    public void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);

        if(prev != null && root.val < prev.val){
            if(first == null) first = prev;
            last = root;
        }
        prev = root;

        inorder(root.right);
    }
    public void recoverTree(TreeNode root){
        first = last = prev = null;
        inorder(root);

        if(first != null && last != null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
    }
}