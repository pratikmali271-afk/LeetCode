// using DFS
class Solution {
    private boolean dfs(int node, boolean[] vis, boolean[] pathVis, Stack<Integer> st, List<List<Integer>> adj) {

        vis[node] = true;
        pathVis[node] = true;

        for (int neigh : adj.get(node)) {
            if (!vis[neigh]) {
                if (!dfs(neigh, vis, pathVis, st, adj)) {
                    return false;
                }
            }
            else if (pathVis[neigh]) {
                return false;
            }
        }
        pathVis[node] = false;
        st.push(node);
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];
            adj.get(prerequisite).add(course);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (!dfs(i, vis, pathVis, st, adj)) {
                    return new int[0];
                }
            }
        }

        int[] topoSort = new int[numCourses];
        int i = 0;
        while (!st.isEmpty()) {
            topoSort[i++] = st.pop();
        }
        return topoSort;
    }
}