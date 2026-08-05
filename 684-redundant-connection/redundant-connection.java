// class Solution {

//     public boolean dfs(int src, int target, ArrayList<ArrayList<Integer>> graph,
//  boolean[] visited){

//         if (src == target) return true;

//         visited[src] = true;

//         for (int neighbour : graph.get(src)) {

//             if (!visited[neighbour]) {

//                 if (dfs(neighbour, target, graph, visited))
//                     return true;
//             }
//         }

//         return false;
//     }

//     public int[] findRedundantConnection(int[][] edges) {

//         int n = edges.length;

//         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

//         for (int i = 0; i <= n; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for (int[] edge : edges) {

//             int u = edge[0];
//             int v = edge[1];

//             boolean[] visited = new boolean[n + 1];

//             if (dfs(u, v, graph, visited)) {
//                 return edge;
//             }

//             graph.get(u).add(v);
//             graph.get(v).add(u);
//         }

//         return new int[0];
//     }
// }

class Solution {
    int[] parent;
    public int find(int node){

        if(parent[node] == node)
            return node;

        return find(parent[node]);
    }

    public void union(int u, int v){

        int pu = find(u);
        int pv = find(v);

        if(pu != pv){

            parent[pv] = pu;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        parent = new int[n+1];

        for(int i=1;i<=n;i++)
            parent[i] = i;

        for(int[] edge : edges){

            int u = edge[0];
            int v = edge[1];

            if(find(u) == find(v))
                return edge;

            union(u,v);
        }

        return new int[0];
    }
}