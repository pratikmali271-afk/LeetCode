// Using BFS
// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
//         int[] color = new int[n];

//         for(int i = 0; i < n; i++){
//             color[i] = -1;
//         }

//         for(int i = 0; i < n; i++){
//             if(color[i] != -1) continue;

//             Queue<Integer> q = new LinkedList<>();
//             q.offer(i);
//             color[i] = 0;

//             while(!q.isEmpty()){
//                 int curr = q.poll();

//                 for(int neigh : graph[curr]){
//                     if(color[neigh] == -1){
//                         color[neigh] = 1 - color[curr];
//                         q.offer(neigh);
//                     } else if(color[neigh] == color[curr]) return false;
//                 }
//             }
//         }
//         return true;
//     }
// }

// Using DFS
class Solution {
    public boolean dfs(int node, int[][] graph, int[] color){
        for(int neigh : graph[node]){
            if(color[neigh] == -1){
                color[neigh] = 1 - color[node];

                if(!dfs(neigh, graph, color)) return false;
            }
            else if(color[neigh] == color[node]) return false;
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for(int i = 0; i < n; i++) color[i] = -1;

        for(int i = 0; i < n; i++){
            if(color[i] != -1) continue;
            color[i] = 0;
            
            if (!dfs(i, graph, color)){
                return false;
            }
        }
        return true;
    }
}