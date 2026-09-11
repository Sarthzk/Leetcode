class Pair{
    int row;
    int col;
    int tm;
    Pair(int _row, int _col, int _tm){
        this.row = _row;
        this.col = _col;
        this.tm = _tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] vis = new int[rows][cols];
        int fresh = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2){
                    queue.add(new Pair(r, c, 0));
                    vis[r][c] = 2;
                }
                else {
                    vis[r][c] = 0;
                }
                if(grid[r][c] == 1) fresh++;
            }
        }

        int tm = 0;
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
        int cnt = 0;

        while(!queue.isEmpty() && fresh > 0){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().tm;
            tm = Math.max(tm, t);
            queue.remove();
            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && nrow < rows && ncol>= 0 && ncol < cols && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    queue.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }

            }
        }
        if(cnt != fresh) return -1;
        return tm;
    }
}