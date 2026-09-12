class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : prerequisites){
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(hasCycle(adj, visited, inStack, i)) return false;
            }
        }
        return true;
    }

    boolean hasCycle(List<List<Integer>> adj, boolean[] visited, boolean[] inStack, int node){
        visited[node] = true;
        inStack[node] = true;

        for(int neighbour : adj.get(node)){
            if(inStack[neighbour]) return true;
            else if(!visited[neighbour]){
                if(hasCycle(adj, visited, inStack, neighbour)) return true;
            }
        }
        inStack[node] = false;
        return false;
    }
}