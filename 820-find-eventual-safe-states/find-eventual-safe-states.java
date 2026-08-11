class Solution {
    public boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] pathVis, boolean[] check){
        vis[node] = true;
        pathVis[node] = true;

        for(int neigh : graph[node]){
            if(!vis[neigh]){
                if(dfs(neigh, graph, vis, pathVis, check)) return true;
            }
            else if(pathVis[neigh]) return true;
        }

        check[node] = true;
        pathVis[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        boolean[] check = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!vis[i]) dfs(i, graph, vis, pathVis, check);
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(check[i]) safeNodes.add(i);
        }

        return safeNodes;
    }
}