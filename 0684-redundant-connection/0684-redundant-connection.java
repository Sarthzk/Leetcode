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

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];

        for(int i = 0; i <= edges.length; i++){
            parent[i] = i;
        }
        for(int[] e : edges){
            if(!union(e[0], e[1])){
                return e;
            }
        }
        return new int[0];
    }
}