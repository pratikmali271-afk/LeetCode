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

    public void markParent(TreeNode root, Map<TreeNode, TreeNode> Parrent_track){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode temp = q.poll();

            if(temp.left != null){
                Parrent_track.put(temp.left, temp);
                q.offer(temp.left);
            }
            if(temp.right != null){
                Parrent_track.put(temp.right, temp);
                q.offer(temp.right);
            }
        }
    }

    public TreeNode findStart(TreeNode root, int start){
        if(root == null)
            return null;

        if(root.val == start)
            return root;

        TreeNode left = findStart(root.left, start);

        if(left != null)
            return left;

        return findStart(root.right, start);
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> Parrent_track = new HashMap<>();
        markParent(root, Parrent_track);

        TreeNode startNode = findStart(root, start);

        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        q.offer(startNode);
        visited.put(startNode, true);

        int min = 0;

        while(!q.isEmpty()){

            int n = q.size();
            boolean infected = false;

            for(int i = 0; i < n; i++){

                TreeNode temp = q.poll();

                if(temp.left != null && visited.get(temp.left) == null){
                    q.offer(temp.left);
                    visited.put(temp.left, true);
                    infected = true;
                }

                if(temp.right != null && visited.get(temp.right) == null){
                    q.offer(temp.right);
                    visited.put(temp.right, true);
                    infected = true;
                }

                if(Parrent_track.get(temp) != null &&
                   visited.get(Parrent_track.get(temp)) == null){

                    q.offer(Parrent_track.get(temp));
                    visited.put(Parrent_track.get(temp), true);
                    infected = true;
                }
            }
            if(infected)
                min++;
        }
        return min;
    }
}