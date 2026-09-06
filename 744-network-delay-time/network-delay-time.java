// class Pair {
//     int node;
//     int time;

//     Pair(int node, int time) {
//         this.node = node;
//         this.time = time;
//     }
// }

// class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         List<List<Pair>> adj = new ArrayList<>();

//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int[] edge : times) {
//             int u = edge[0];
//             int v = edge[1];
//             int wt = edge[2];

//             adj.get(u).add(new Pair(v, wt));
//         }

//         int[] dist = new int[n + 1];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[k] = 0;

//         PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
//         pq.offer(new Pair(k, 0));

//         // Dijkstra
//         while (!pq.isEmpty()) {
//             Pair curr = pq.poll();

//             int node = curr.node;
//             int time = curr.time;

//             if (time > dist[node]) {
//                 continue;
//             }

//             for (Pair neighbor : adj.get(node)) {

//                 int nextNode = neighbor.node;
//                 int weight = neighbor.time;

//                 if (time + weight < dist[nextNode]) {
//                     dist[nextNode] = time + weight;
//                     pq.offer(new Pair(nextNode, dist[nextNode]));
//                 }
//             }
//         }
//         int maxTime = 0;
//         for (int i = 1; i <= n; i++) {
//             if (dist[i] == Integer.MAX_VALUE) {
//                 return -1;
//             }
//             maxTime = Math.max(maxTime, dist[i]);
//         }
//         return maxTime;
//     }
// }

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        for(int i = 0; i < n - 1; i++){
            for (int[] edge : times){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}