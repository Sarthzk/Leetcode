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
                if(hasCycle(adj, visited, inStack, i)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean hasCycle(List<List<Integer>> adj, boolean[] visited, boolean[] inStack, int course){
        inStack[course] = true;

        for(int next : adj.get(course)){
            if(inStack[next]){
                return true;
            }
            if(!visited[next]){
                if(hasCycle(adj, visited, inStack, next)){
                    return true;
                }
            }
        }

        inStack[course] = false;
        visited[course] = true;

        return false;

    }
}