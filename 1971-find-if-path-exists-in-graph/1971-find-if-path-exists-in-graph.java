class Solution {
    int[] parent;

    int find(int x){
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    boolean union(int a, int b){
        int ra = find(a);
        int rb = find(b);

        if(ra == rb) return false;
        parent[ra] = rb;
        return true;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int[] e : edges){
            union(e[0], e[1]);
        }

        return find(source) == find(destination);
    }
}