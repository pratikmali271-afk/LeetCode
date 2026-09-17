class Solution {
    private int timer = 1;
    private void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, List<List<Integer>> bridges,  List<List<Integer>> adj){
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;

        for(Integer it : adj.get(node)){
            if(it == parent) continue;
            if(!vis[it]){
                dfs(it, node, vis, tin, low, bridges, adj);
                low[node] = Math.min(low[node], low[it]);

                if(low[it] > tin[node]){
                    bridges.add(Arrays.asList(it, node));
                }
            }
            else{
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> it : connections){
            int u = it.get(0);
            int v = it.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, vis, tin, low, bridges, adj);
        return bridges;
    }
}