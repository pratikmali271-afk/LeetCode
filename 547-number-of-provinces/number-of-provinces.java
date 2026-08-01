class Solution {
    public void dfs(int city, int[][] isConnected, boolean[] vis){
        vis[city] = true;
        for(int neighbor = 0; neighbor < isConnected.length; neighbor++){
            if(isConnected[city][neighbor] == 1 && !vis[neighbor]) dfs(neighbor, isConnected, vis);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                count++;
                dfs(i, isConnected, vis);
            }
        }
        return count;
    }
}