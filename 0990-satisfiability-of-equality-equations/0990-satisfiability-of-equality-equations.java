class Solution {
    int[] parent;

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
            return parent[x];
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
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        

        for(int i = 0; i < 26; i++){
            parent[i] = i;
        }

        for(String s : equations){
            int a = s.charAt(0) - 'a';
            int b = s.charAt(3) - 'a';
            if(s.charAt(1) == '='){
                union(a, b);
            }
        }

        for(String s : equations){
            int a = s.charAt(0) - 'a';
            int b = s.charAt(3) - 'a';
            if(s.charAt(1) == '!'){
                if(find(a) == find(b)) return false;
            }
        }
        return true;
    }
}