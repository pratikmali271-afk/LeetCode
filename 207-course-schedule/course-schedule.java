class Solution {
    public boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis){
        vis[node] = true;
        pathVis[node] = true;

        for(int neigh : adj.get(node)){
            if(!vis[neigh]){
                if(dfs(neigh, adj, vis, pathVis)) return true;
            }
            else if(pathVis[neigh]) return true;
        }

        pathVis[node] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int[] edges : prerequisites){
            int course = edges[0];
            int prerequesite = edges[1];
            adj.get(prerequesite).add(course);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!vis[i]){
                if(dfs(i, adj, vis, pathVis)) return false;
            }
        }
        return true;
    }
}
