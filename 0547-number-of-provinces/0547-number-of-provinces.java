class Solution {
    int[] parent;

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
            return parent[x];
        }
        else {
            return x;
        }
    }

    boolean union(int a, int b){
        int ra = find(a);
        int rb = find(b);

        if(ra == rb) return false;
        parent[ra] = rb;
        return true;
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = n;
        
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    if(union(i, j)) count--;
                }
            }
        }
        return count;
    }
}