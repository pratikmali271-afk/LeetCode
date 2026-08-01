class Solution {
    // public void dfs(int city, int[][] isConnected, boolean[] vis){
    //     vis[city] = true;
    //     for(int neighbor = 0; neighbor < isConnected.length; neighbor++){
    //         if(isConnected[city][neighbor] == 1 && !vis[neighbor]) dfs(neighbor, isConnected, vis);
    //     }
    // }
    // public int findCircleNum(int[][] isConnected) {
    //     int n = isConnected.length;
    //     boolean[] vis = new boolean[n];
    //     int count = 0;

    //     for(int i = 0; i < n; i++){
    //         if(!vis[i]){
    //             count++;
    //             dfs(i, isConnected, vis);
    //         }
    //     }
    //     return count;
    // }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }

        return count;
    }
}