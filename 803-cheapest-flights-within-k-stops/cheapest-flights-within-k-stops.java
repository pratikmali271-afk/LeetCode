class pair{
    int first;
    int second;
    pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class tuple{
    int stops;
    int node;
    int distance;
    tuple(int stops, int node, int distance){
        this.stops = stops;
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new pair(flights[i][1], flights[i][2]));
        }

        Queue<tuple> q = new LinkedList<>();
        q.offer(new tuple(0, src, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while(!q.isEmpty()){
            tuple curr = q.poll();
            int stops = curr.stops;
            int node = curr.node;
            int cost = curr.distance;

            if(stops > k) continue;

            for(pair it : adj.get(node)){
                int adjNode = it.first;
                int adjdist = it.second;

                if(cost + adjdist < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + adjdist;
                    q.offer(new tuple(stops + 1, adjNode, cost + adjdist));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}