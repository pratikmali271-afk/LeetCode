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
    int PreIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode build(int[] preorder, int inStart, int inEnd){
        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[PreIndex++]);
        int index = map.get(root.val);

        root.left = build(preorder, inStart, index - 1);
        root.right = build(preorder, index + 1, inEnd);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }
}