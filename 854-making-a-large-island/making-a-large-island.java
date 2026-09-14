class DisjointSet {
    int[] parent;
    int[] size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findPar(int u) {
        if (parent[u] == u) {
            return u;
        }
        int up = findPar(parent[u]);
        parent[u] = up;
        return up;
    }

    void unionBySize(int u, int v) {
        int pu = findPar(u);
        int pv = findPar(v);

        if (pu == pv) {
            return;
        }

        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        else if (size[pv] > size[pu]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        DisjointSet ds = new DisjointSet(n*m);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0) continue;

                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, -1, 0, 1};

                for(int k = 0; k < 4; k++){
                    int nRow = i + dr[k];
                    int nCol = j + dc[k];
                    if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && grid[nRow][nCol] == 1){
                        int nodeNo = i*m + j;
                        int adjnodeNo = nRow*m + nCol;
                        ds.unionBySize(nodeNo, adjnodeNo);
                    }
                }
            }
        }

        int max = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    continue;
                }
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, -1, 0, 1};
                HashSet<Integer> comp = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nRow = i + dr[k];
                    int nCol = j + dc[k];
                    if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && grid[nRow][nCol] == 1) {
                        int adjNodeNo = nRow * m + nCol;
                        comp.add(ds.findPar(adjNodeNo));
                    }
                }
                int sizeTotal = 0;
                for (Integer parent : comp) {
                    sizeTotal += ds.size[parent];
                }
                max = Math.max(max, sizeTotal + 1);
            }
        }
        // Handles the case where the grid is already full of ones
        for (int cellNo = 0; cellNo < n * m; cellNo++) {
            int parent = ds.findPar(cellNo);

            max = Math.max(max, ds.size[parent]);
        }
        return max;
    }
}