class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(mat[r][c] == 0){
                    dist[r][c] = 0;
                    q.offer(new int[]{r, c});
                }
                else {
                    dist[r][c] = -1;
                }
            }
        }
        int[] dirs = new int[]{0, 1, 0, -1, 0};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i < 4; i++){
                int nr = r + dirs[i];
                int nc = c + dirs[i+1];
                if(nr < 0 || nr > m-1 || nc < 0 || nc > n-1) continue;
                if(dist[nr][nc] != -1) continue;
                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});

            }
        }
        return dist;
    }
}