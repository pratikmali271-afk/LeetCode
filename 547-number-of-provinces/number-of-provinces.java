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
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[0].length; j++){
                if(isConnected[i][j] == 1) ds.unionByRank(i, j);
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(ds.parent[i] == i) count++;
        }
        return count;
    }
}