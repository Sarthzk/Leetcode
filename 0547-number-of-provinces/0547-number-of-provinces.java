class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i = 0; i < n; i++){
            if (!visited[i]){
                provinces++;
                dfs(isConnected, visited, i);
            }
        }
        return provinces;
    }

    void dfs(int[][] isConnected, boolean[] visited, int city){
        int n = isConnected.length;
        visited[city] = true;

        for(int j = 0; j < n; j++){
            if(isConnected[city][j] == 1 && !visited[j]){
                dfs(isConnected, visited, j);
            }
        }
    }
}