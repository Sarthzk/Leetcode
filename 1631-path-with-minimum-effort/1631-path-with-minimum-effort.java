class Solution {
    int[] dir = new int[]{0, 1, 0, -1, 0};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(d > dist[r][c]) continue;

            if(r == m - 1 && c == n - 1) return d;

            for(int i = 0; i < 4; i++){
                int nr = r + dir[i], nc = c + dir[i+1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    int newDist = Math.max(d, Math.abs(heights[nr][nc] - heights[r][c]));
                    if(dist[nr][nc] > newDist){
                        dist[nr][nc] = newDist;
                        pq.offer(new int[]{dist[nr][nc], nr, nc});
                    }
                }
            }
        }
        return 0;
    }
}