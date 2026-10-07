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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        parent = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            List<String> acc = accounts.get(i);
            for(int j = 1; j < acc.size(); j++){
                String email = acc.get(j);
                if(map.containsKey(email)){
                    union(i, map.get(email));
                }
                else {
                    map.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();

        for (Map.Entry<String, Integer> e : map.entrySet()) {
        String email = e.getKey();          
        int owner = e.getValue();           
        int leader = find(owner);         
        groups.computeIfAbsent(leader, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();

        for(Map.Entry<Integer, List<String>> g : groups.entrySet()){
            int leader = g.getKey();
            List<String> email = g.getValue();
            Collections.sort(email);
            List<String> row = new ArrayList<>();
            row.add(accounts.get(leader).get(0));    
            row.addAll(email);                      
            res.add(row); 
        }

        return res;
    }
}