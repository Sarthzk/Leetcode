class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2) queue.offer(new int[]{r, c});
                if(grid[r][c] == 1) fresh++;
            }
        }
        int minutes = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty() && fresh > 0){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] d : dirs){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                    if(grid[nr][nc] != 1) continue;

                    grid[nr][nc] = 2;
                    fresh--;
                    queue.offer(new int[]{nr, nc});
                }

            }
            minutes++;
        }
        if(fresh != 0) return -1;
        return minutes;
        
    }
}