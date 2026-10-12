class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int[] curr = edges[i];
            adj.get(curr[0]).add(new double[]{curr[1], succProb[i]});
            adj.get(curr[1]).add(new double[]{curr[0], succProb[i]});
        }
        double[] prob = new double[n];
        prob[start_node] = 1.0;

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start_node, 1.0});

        while(!pq.isEmpty()){
            double[] cur = pq.poll();
            int node = (int) cur[0];
            double p = cur[1];
            if(p < prob[node]) continue;

            for(double[] edge : adj.get(node)){
                int next = (int) edge[0];
                double w = edge[1];
                if(p * w > prob[next]){
                    prob[next] = p * w;
                    pq.offer(new double[]{next, p * w});
                }
            }
        }
        return prob[end_node];

    }
}