/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;

        // Queue<Node> q = new LinkedList<>();
        // q.offer(root);

        // while(!q.isEmpty()){
        //     int n = q.size();

        //     int i = 0;
        //     while(i < n){
        //         Node temp = q.poll();

        //         if(i == n - 1){
        //             temp.next = null;
        //         }
        //         else{
        //             temp.next = q.peek();
        //         }

        //         if(temp.left != null) q.offer(temp.left);
        //         if(temp.right != null) q.offer(temp.right);

        //         i++;
        //     }
        // }

        // Extra Space: O(1)
        if(root.left != null){
            root.left.next = root.right;

            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);

        return root;
    }
}