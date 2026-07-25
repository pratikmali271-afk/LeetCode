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
    // Map<Integer, Integer> map = new HashMap<>();
    int preindex = 0;

    // public TreeNode buildTree(int[] pre, int[] in){
    //     for(int i = 0; i < pre.length; i++){
    //         map.put(in[i], i);
    //     }

    //     return build(pre, 0, in.length - 1);
    // }
    // public TreeNode build(int[] pre, int inStart, int inEnd){
    //     if(inStart > inEnd) return null;

    //     TreeNode root = new TreeNode(pre[preindex++]);
    //     int index = map.get(root.val);

    //     root.left = build(pre, inStart, index - 1);
    //     root.right = build(pre, index + 1, inEnd);

    //     return root;
    // }
    public TreeNode buildBST(int[] pre, int bound){
        if(preindex == pre.length || pre[preindex] > bound) return null;

        TreeNode root = new TreeNode(pre[preindex++]);
        root.left = buildBST(pre, root.val);
        root.right = buildBST(pre, bound);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        // int[] inorder = preorder.clone();
        // Arrays.sort(inorder);
        // return buildTree(preorder, inorder);
        return buildBST(preorder, Integer.MAX_VALUE);
    }
}