class Solution {
    int[] parent;

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
            return parent[x];
        }
        else return x;
    }

    boolean union(int a, int b){
        int ra = find(a);
        int rb = find(b);

        if(ra == rb) return false;
        parent[ra] = rb;
        return true;
    }

    public int makeConnected(int n, int[][] connections) {
        int l = connections.length;
        if(l < n - 1) return -1;

        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        int count = n;

        for(int[] c : connections){
            if(union(c[0], c[1])){
                count--;
            }
        }
        return count - 1;
    }
}