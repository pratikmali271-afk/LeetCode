class Pair {
    long first;
    int second;

    Pair(long first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int time = roads[i][2];

            adj.get(u).add(new Pair(time, v));
            adj.get(v).add(new Pair(time, u));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first));
        pq.offer(new Pair(0, 0));

        int MOD = 1000000007;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long distance = curr.first;
            int node = curr.second;

            for (Pair it : adj.get(node)) {
                long edgeWeight = it.first;
                int next = it.second;
                long newDist = distance + edgeWeight;

                // Found a shorter path
                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    pq.offer(new Pair(newDist, next));
                }

                // Found another shortest path
                else if (newDist == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
}