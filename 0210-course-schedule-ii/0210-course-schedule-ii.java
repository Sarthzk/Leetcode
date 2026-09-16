class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()){
            int course = queue.poll();
            res[index] = course;
            index++;

            for(int next : adj.get(course)){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        if(index == numCourses) return res;
        return new int[0];
    }
}