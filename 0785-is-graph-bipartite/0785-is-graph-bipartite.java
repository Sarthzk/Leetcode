class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for(int start = 0; start < n; start++){
            if(color[start] != -1) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            color[start] = 0;

            while(!q.isEmpty()){
                int node = q.poll();
                for(int nb : graph[node]){
                    if(color[nb] == -1){
                        color[nb] = 1 - color[node];
                        q.offer(nb);
                    } else if (color[nb] == color[node]) {
                        return false;
                    }
                    
                }
            }
        }
        return true;
    }
}