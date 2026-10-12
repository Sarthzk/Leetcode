class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = grid[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[] dirs = new int[]{0, 1, 0, -1, 0};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(d > dist[r][c]) continue;

            if(r == n-1 && c == n-1) return d;

            for(int i = 0; i < 4; i++){
                int nr = r + dirs[i], nc = c + dirs[i+1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                    int newTime = Math.max(d, grid[nr][nc]);
                    if(newTime < dist[nr][nc]){
                        dist[nr][nc] = newTime;
                        pq.offer(new int[]{newTime, nr, nc});
                    }

                }
            }
        }
        return -1;
    }
}