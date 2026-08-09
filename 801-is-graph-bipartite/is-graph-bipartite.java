class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for(int i = 0; i < n; i++){
            color[i] = -1;
        }

        for(int i = 0; i < n; i++){
            if(color[i] != -1) continue;

            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            color[i] = 0;

            while(!q.isEmpty()){
                int curr = q.poll();

                for(int neigh : graph[curr]){
                    if(color[neigh] == -1){
                        color[neigh] = 1 - color[curr];
                        q.offer(neigh);
                    } else if(color[neigh] == color[curr]) return false;
                }
            }
        }
        return true;
    }
}