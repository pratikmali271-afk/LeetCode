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

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return list;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);

        return list;  
    }

    //Using 2 stack
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
        
    //     if(root == null) return new ArrayList<>();

    //     Stack<TreeNode> st1 = new Stack<>();
    //     Stack<TreeNode> st2 = new Stack<>();

    //     st1.push(root);
    //     while(!st1.isEmpty()){
    //         root = st1.pop();
    //         st2.push(root);

    //         if(root.left != null) st1.push(root.left);
    //         if(root.right != null) st1.push(root.right);
    //     }

    //     while(!st2.isEmpty()){
    //         list.add(st2.pop().val);
    //     }
    //     return list;
    // }

    //Using 1 stack
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();

    //     if(root == null)
    //         return list;

    //     Stack<TreeNode> st = new Stack<>();

    //     TreeNode curr = root;
    //     while(curr != null || !st.isEmpty()){
    //         if(curr != null){
    //             st.push(curr);
    //             curr = curr.left;
    //         }
    //         else{
    //             TreeNode temp = st.peek().right;
    //             if(temp == null){
    //                 temp = st.pop();
    //                 list.add(temp.val);

    //                 while(!st.isEmpty() && temp == st.peek().right){
    //                     temp = st.pop();
    //                     list.add(temp.val);
    //                 }
    //             }
    //             else{
    //                 curr = temp;
    //             }
    //         }
    //     }

    //     return list;
    // }
}