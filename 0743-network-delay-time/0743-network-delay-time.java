class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for(int[] e : times) {
            adj.get(e[0]).add(new int[] {e[1], e[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if(d > dist[node]) continue;

            for(int[] edge : adj.get(node)) {
                int next = edge[0], w = edge[1];
                if(d + w < dist[next]) {
                    dist[next] = d + w;
                    pq.offer(new int[]{next, d + w});
                }
            }

        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}