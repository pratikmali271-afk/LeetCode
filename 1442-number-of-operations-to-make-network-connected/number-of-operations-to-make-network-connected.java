class DisjointSet{
    int[] parent;
    int[] rank;

    DisjointSet(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int findPar(int u){
        if(u == parent[u]) return u;
        int up = findPar(parent[u]);
        parent[u] = up;
        return up;
    }

    void unionByRank(int u, int v){
        int pu = findPar(u);
        int pv = findPar(v);

        if(pu == pv) return;

        if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }
        else if(rank[pv] < rank[pu]){
            parent[pv] = pu;
        }
        else{
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
       // int n = connections.length;
        DisjointSet ds = new DisjointSet(n);

        int extraEdges = 0;
        for(int i = 0; i < connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];

            if(ds.findPar(u) == ds.findPar(v)){
                extraEdges++;
            } else{
                ds.unionByRank(u, v);
            }
        }

        int cntC = 0;
        for(int i = 0; i < n; i++){
            if(ds.parent[i] == i) cntC++;
        }

        int ans = cntC - 1;
        if(extraEdges >= ans) return ans;
        return -1;
    }
}